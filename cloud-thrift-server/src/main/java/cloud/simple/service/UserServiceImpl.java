package cloud.simple.service;

import cloud.simple.interfaces.UserDto;
import cloud.simple.interfaces.UserService;
import org.apache.thrift.TException;

public class UserServiceImpl implements UserService.Iface{

	@Override
	public UserDto getUser() throws TException
	  {		
		UserDto user = new UserDto(1000,"david");
		return user;
	  }

}
