package com.zzz.dubboapi.test.service;


import com.zzz.dubboapi.test.pojo.dos.UserDO;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/12 17:35
 */
public interface UserService {

	/**
	 * description: 测试
	 * @author zwq
	 * @date 2022/4/13 17:22
	 * @return java.lang.String
	 */
	String getString();

	/**
	 * description: 获取用户
	 * @author zwq
	 * @date 2022/4/18 17:24
	 * @param id
	 * @return com.zzz.dubboapi.test.pojo.dos.UserDO
	 */
	UserDO getUser(int id);

	/**
	 * description: 更新信息
	 * @author zwq
	 * @date 2022/4/18 15:05
	 * @param userDO 用户实体
	 * @return int
	 */
	int updateUser(UserDO userDO);

}
