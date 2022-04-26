package com.zzz.pped.test.service.impl;

import com.zzz.dubboapi.test.pojo.dos.GoodDO;
import com.zzz.dubboapi.test.pojo.dos.RecordDO;
import com.zzz.dubboapi.test.pojo.dos.UserDO;
import com.zzz.dubboapi.test.pojo.dos.UserGoodDO;
import com.zzz.dubboapi.test.service.GoodService;
import com.zzz.dubboapi.test.service.RecordService;
import com.zzz.dubboapi.test.service.UserGoodService;
import com.zzz.dubboapi.test.service.UserService;
import com.zzz.pped.test.service.SeataService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/22 10:10
 */
@DubboService
@Slf4j
@RequiredArgsConstructor
public class SeataServiceImpl implements SeataService{

	@DubboReference
	private UserService userService;

	@DubboReference
	private RecordService recordService;

	private final GoodService goodService;

	private final UserGoodService userGoodService;


	/**
	 * description: TODO
	 *
	 * @return java.lang.String
	 * @author zwq
	 * @date 2022/4/22 10:09
	 */
	@Override
	@GlobalTransactional
	public String test() {
		log.info("Seata全局事务id=================>{}", RootContext.getXID());
		GoodDO goodDO = goodService.getGood(1);
		UserDO userDO = userService.getUser(1);
		userDO.setGold(userDO.getGold().subtract(goodDO.getPrice()));
		userService.updateUser(userDO);
		if (userDO != null) {
			System.out.println("回滚");
			throw new RuntimeException("回滚");
		}
		RecordDO recordDO = new RecordDO();
		recordDO.setUserId(userDO.getId());
		recordDO.setGoodId(goodDO.getId());
		recordDO.setContent(new Date() + userDO.getName() + "买了" + goodDO.getName());
		recordService.insertRecord(recordDO);

		UserGoodDO userGoodDO = new UserGoodDO();
		userGoodDO.setUserId(userDO.getId());
		userGoodDO.setGoodId(goodDO.getId());
		userGoodService.insertUserGood(userGoodDO);
		return userDO.toString();
	}
}
