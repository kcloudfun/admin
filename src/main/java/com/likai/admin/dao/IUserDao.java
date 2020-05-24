package com.likai.admin.dao;

import java.util.List;

import com.likai.admin.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {

	/**
	 * 查全部user
	 * 
	 * @return
	 */
	List<User> selectAll();

	/**
	 * 新增
	 * 
	 * @param user
	 * @return
	 */
	int InsertUser(User user);

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	User selectUserByCondition(User user);

	/**
	 * 更新
	 *
	 * @param user
	 * @return
	 */
	int updateUser(User user);
}
