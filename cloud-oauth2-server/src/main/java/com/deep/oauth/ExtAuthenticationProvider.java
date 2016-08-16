package com.deep.oauth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.deep.user.User;


@Service
public class ExtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	private static final String USER_NOT_FOUND_PASSWORD = "userNotFoundPassword"; 
    @Autowired
	private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    private Md5PasswordEncoder md5PasswordEncoder =  new Md5PasswordEncoder();

    public ExtAuthenticationProvider() {
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
       

        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
        }
        User user = userService.findByAccount(userDetails.getUsername());
        if (user.getLocked()) {
        	throw new BadCredentialsException(messages.getMessage("account is locked","Bad account"));
		}
        String rawPass = authentication.getCredentials().toString();
        String encodePassword = DigestUtils.md5Hex(rawPass);
        
        boolean b = encodePassword.equals(userDetails.getPassword());
        if (!b) {
            logger.debug("Authentication failed: password does not match stored value");

			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
        }
        
    }

    protected void doAfterPropertiesSet() throws Exception {
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
        } catch (UsernameNotFoundException notFound) {
            if(authentication.getCredentials() != null) {
                String presentedPassword = authentication.getCredentials().toString();
                String userNotFoundEncodedPassword = md5PasswordEncoder.encodePassword(USER_NOT_FOUND_PASSWORD, null);
                md5PasswordEncoder.isPasswordValid(userNotFoundEncodedPassword, presentedPassword, null);
            }
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

 
    protected UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
   
}
