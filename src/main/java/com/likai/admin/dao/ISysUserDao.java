package com.likai.admin.dao;


import com.likai.admin.po.SysUser;

public interface ISysUserDao {

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return
     */
    SysUser selectUserByName(String name);
}