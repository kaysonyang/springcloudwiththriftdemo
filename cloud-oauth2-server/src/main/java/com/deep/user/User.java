package com.deep.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="myuser")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String mobile;
	@Column
	private String lastip;
	@Column
	private Date lastvisit;
	@Column
	private Boolean  locked;
	
	
	public User() {
		super();
	}
	public User(User u) {
		userId = u.getUserId();
		email = u.getEmail();
		username = u.getUsername();
		mobile = u.getMobile();
		lastip = u.getLastip();
		locked = u.getLocked();
		password  =u.getPassword();
		lastvisit = u.getLastvisit();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public Date getLastvisit() {
		return lastvisit;
	}
	public void setLastvisit(Date lastvisit) {
		this.lastvisit = lastvisit;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	
	

}
