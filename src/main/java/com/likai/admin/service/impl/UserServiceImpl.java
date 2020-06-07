package com.likai.admin.service.impl;


import com.likai.admin.dao.ISysUserDao;
import com.likai.admin.po.SysUser;
import com.likai.common.constant.ObjectSourceEnum;
import com.likai.common.dao.ITemplateDao;
import com.likai.common.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 使用Spring Security要求必须实现UserDetailsService，故不要再定义其他接口了，不然自动注入时会有问题。
 * 只遵循一个接口规范，从代码角度来说也更加简单明了
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired(required = false)
    private ITemplateDao templateDao;

    @Autowired(required = false)
    private ISysUserDao sysUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean addUser(SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int a = templateDao.oneInsert("sys_user", BeanUtils.bean2map(user, ObjectSourceEnum.NORMAL.getValue()));
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = sysUserDao.selectUserByName(name);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("用户" + name + "未找到");
        }

    }
}
