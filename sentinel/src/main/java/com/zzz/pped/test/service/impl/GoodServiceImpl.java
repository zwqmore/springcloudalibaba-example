package com.zzz.pped.test.service.impl;

import com.zzz.dubboapi.test.pojo.dos.GoodDO;
import com.zzz.dubboapi.test.service.GoodService;
import com.zzz.pped.test.mapper.GoodMapper;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 16:04
 */
@RequiredArgsConstructor
@DubboService
public class GoodServiceImpl implements GoodService {

	private final GoodMapper goodMapper;

	/**
	 * description: 获取商品
	 *
	 * @param id id
	 * @return com.zzz.dubboapi.test.pojo.dos.GoodDO
	 * @author zwq
	 * @date 2022/4/18 17:21
	 */
	@Override
	public GoodDO getGood(int id) {
		com.zzz.pped.test.pojo.dos.GoodDO goodDO = goodMapper.selectById(id);
		GoodDO target = new GoodDO();
		BeanUtils.copyProperties(goodDO, target);
		return target;
	}

	/**
	 * description: 更新信息
	 *
	 * @param goodDO 信息
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 15:10
	 */
	@Override
	public int updateGood(GoodDO goodDO) {
		com.zzz.pped.test.pojo.dos.GoodDO target = new com.zzz.pped.test.pojo.dos.GoodDO();
		BeanUtils.copyProperties(goodDO, target);
		return goodMapper.updateById(target);
	}
}
