package com.deep.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deep.user.User;

import net.sf.json.JSONObject;

import java.security.Principal;


@RestController
public class HomeAction {
	private Logger logger = LoggerFactory.getLogger(HomeAction.class);
	
	@RequestMapping("/index")
	public String home(@AuthenticationPrincipal User user) throws Exception {
		JSONObject jsonObject = new JSONObject();
		if (user != null) {
			logger.debug(user.getUsername());
		}
		return jsonObject.toString();
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
  