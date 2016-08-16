package com.deep.oauth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.user.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public User findByAccount(String account){
		User user = null;
		boolean isMobile = isMobile(account);
		if (isMobile) {
			user = userDao.findByMobile(account);
			return user;
		}
		boolean isEmail = isEmail(account);
		if (isEmail) {
			user = userDao.findByEmail(account);
			return user;
		}
		else{
			user = userDao.findByUsername(account);
			return user;
		}
	}
	public static  boolean isMobile(String mobile){
		Pattern p = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	public static boolean isEmail(String email){
		boolean matchEmail = Pattern.matches("\\w+((\\.|\\-|\\+)\\w+)*@([\\w\\-]+\\.)+(\\w{2,4})+", email);
		return matchEmail;
	}
}
