package com.zzz.pped.test.service.impl;

import com.zzz.dubboapi.test.pojo.dos.UserGoodDO;
import com.zzz.dubboapi.test.service.UserGoodService;
import com.zzz.pped.test.mapper.UserGoodMapper;
import org.apache.dubbo.config.annotation.DubboService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 16:04
 */
@RequiredArgsConstructor
@DubboService
public class UserGoodServiceImpl implements UserGoodService {

	private final UserGoodMapper userGoodMapper;

	/**
	 * description: 插入数据
	 *
	 * @param userGoodDO 信息
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 17:13
	 */
	@Override
	public int insertUserGood(UserGoodDO userGoodDO) {
		com.zzz.pped.test.pojo.dos.UserGoodDO target = new com.zzz.pped.test.pojo.dos.UserGoodDO();
		BeanUtils.copyProperties(userGoodDO, target);
		return userGoodMapper.insert(target);
	}

	/**
	 * description: 更新信息
	 *
	 * @param userGoodDO 信息
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 15:10
	 */
	@Override
	public int updateUserGood(UserGoodDO userGoodDO) {
		com.zzz.pped.test.pojo.dos.UserGoodDO target = new com.zzz.pped.test.pojo.dos.UserGoodDO();
		BeanUtils.copyProperties(userGoodDO, target);
		return userGoodMapper.updateById(target);
	}
}
