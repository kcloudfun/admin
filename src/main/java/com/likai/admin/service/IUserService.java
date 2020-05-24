package com.likai.admin.service;

import com.likai.admin.po.SysUser;
import com.likai.admin.po.User;

import java.util.List;


public interface IUserService {

	List<User> getAll();
	
	void addUser(SysUser user);

}
