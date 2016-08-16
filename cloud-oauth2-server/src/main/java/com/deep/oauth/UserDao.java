package com.deep.oauth;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.deep.user.User;


@Repository
public interface UserDao  extends PagingAndSortingRepository<User, Integer> {

	public User findByUserId(Integer userId);

	public User findByMobile(String mobile);

	public User findByUsername(String username);
	public User findByEmail(String email);
	
}
