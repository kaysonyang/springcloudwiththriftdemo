package cloud.simple.controller;

import cloud.simple.interfaces.UserDto;
import cloud.simple.interfaces.UserService;
import cloud.simple.provider.UserServiceProvider;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
	
	
	@Autowired
	UserServiceProvider userServiceProvider;

	@ResponseBody
	@RequestMapping(value = "/hello")
	String hello() throws TException {
		UserService.Client svr=userServiceProvider.getBalanceUserService();
		UserDto userDto= svr.getUser();
		return Optional.ofNullable(userDto.getUsername())
				.map(name -> "hello "+name)
				.orElse(" hello kayson");
	}
}
