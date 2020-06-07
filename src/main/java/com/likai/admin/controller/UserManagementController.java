package com.likai.admin.controller;

import java.util.List;

import com.likai.admin.po.SysUser;
import com.likai.admin.service.impl.UserServiceImpl;
import com.likai.admin.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/user/v1")
public class UserManagementController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public CommonResult<?> addUser(@RequestBody SysUser user) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean flag = userService.addUser(user);
        res.setData(flag);
        return res;
    }
}
