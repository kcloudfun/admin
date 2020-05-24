package com.likai.admin.service.impl;

import java.util.List;

import com.likai.admin.po.SysUser;
import com.likai.admin.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likai.admin.dao.IUserDao;
import com.likai.admin.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired(required = false)
	private IUserDao userDao;

	@Override
	public List<User> getAll() {
		return userDao.selectAll();
	}

	@Override
	public void addUser(SysUser user) {
		//templateDao.oneInsert("sys_user", BeanUtils.bean2map(user,0));
	}

}
