package com.zzz.dubboapi.test.service;


import com.zzz.dubboapi.test.pojo.dos.UserGoodDO;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:09
 */
public interface UserGoodService {

	/**
	 * description: 更新信息
	 * @author zwq
	 * @date 2022/4/18 15:10
	 * @param userGoodDO 信息
	 * @return int
	 */
	int updateUserGood(UserGoodDO userGoodDO);

	/**
	 * description: 插入数据
	 * @author zwq
	 * @date 2022/4/18 17:13
	 * @param userGoodDO 信息
	 * @return int
	 */
	int insertUserGood(UserGoodDO userGoodDO);

}
