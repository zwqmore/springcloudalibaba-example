package com.zzz.dubboapi.test.service;


import com.zzz.dubboapi.test.pojo.dos.GoodDO;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:09
 */
public interface GoodService {

	/**
	 * description: 获取商品
	 * @author zwq
	 * @date 2022/4/18 17:21
	 * @param id
	 * @return com.zzz.dubboapi.test.pojo.dos.GoodDO
	 */
	GoodDO getGood(int id);

	/**
	 * description: 更新信息
	 * @author zwq
	 * @date 2022/4/18 15:10
	 * @param goodDO 信息
	 * @return int
	 */
	int updateGood(GoodDO goodDO);

}
