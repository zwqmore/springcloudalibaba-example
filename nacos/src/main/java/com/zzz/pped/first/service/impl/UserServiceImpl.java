package com.zzz.pped.first.service.impl;


import com.zzz.dubboapi.test.pojo.dos.UserDO;
import com.zzz.dubboapi.test.service.UserService;
import com.zzz.pped.first.mapper.UserMapper;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import sun.rmi.runtime.Log;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/13 17:23
 */
@Slf4j
@DubboService
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	/**
	 * description: 测试
	 *
	 * @return java.lang.String
	 * @author zwq
	 * @date 2022/4/13 17:22
	 */
	@Override
	public String getString() {
		return "hello i'm nacos";
	}

	/**
	 * description: 获取用户
	 *
	 * @param id
	 * @return com.zzz.dubboapi.test.pojo.dos.UserDO
	 * @author zwq
	 * @date 2022/4/18 17:24
	 */
	@Override
	public UserDO getUser(int id) {
		log.info("Seata全局事务id=================>{}", RootContext.getXID());
		com.zzz.pped.first.pojo.dos.UserDO userDO = userMapper.selectById(id);
		log.info("userDO:{}", userDO);
		System.out.println("userDo" + userDO);
		com.zzz.dubboapi.test.pojo.dos.UserDO userDOTarget = new com.zzz.dubboapi.test.pojo.dos.UserDO();
		BeanUtils.copyProperties(userDO, userDOTarget);
		return userDOTarget;
	}

	/**
	 * description: 更新信息
	 *
	 * @param userDO 用户实体
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 15:05
	 */
	@Override
	public int updateUser(UserDO userDO) {
		com.zzz.pped.first.pojo.dos.UserDO userDO1 = new com.zzz.pped.first.pojo.dos.UserDO();
		BeanUtils.copyProperties(userDO, userDO1);
		return userMapper.updateById(userDO1);
	}
}
