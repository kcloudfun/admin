package com.likai.admin.controller;

import java.util.List;

import com.likai.admin.po.SysUser;
import com.likai.admin.po.User;
import com.likai.admin.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.likai.admin.service.IUserService;

@RestController
@RequestMapping("/admin/user/v1")
public class UserManagementController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public CommonResult<?> getAllUser() {
		CommonResult<List<User>> res = new CommonResult<>();
		res.setData(userService.getAll());
		return res;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult<?> addUser(@RequestBody SysUser user) {
		CommonResult<List<User>> res = new CommonResult<>();
		userService.addUser(user);
		return res;
	}
}
