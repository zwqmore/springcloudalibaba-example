package com.zzz.pped.test.service.impl;

import com.zzz.dubboapi.test.pojo.dos.RecordDO;
import com.zzz.dubboapi.test.service.RecordService;
import com.zzz.pped.test.mapper.RecordMapper;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 17:01
 */
@Slf4j
@RequiredArgsConstructor
@DubboService
public class RecordServiceImpl implements RecordService {

	private final RecordMapper recordMapper;

	/**
	 * description: 更新信息
	 *
	 * @param recordDO 信息
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 15:10
	 */
	@Override
	public int updateRecord(RecordDO recordDO) {
		com.zzz.pped.test.pojo.dos.RecordDO target = new com.zzz.pped.test.pojo.dos.RecordDO();
		BeanUtils.copyProperties(recordDO, target);
		return recordMapper.updateById(target);
	}

	/**
	 * description: 插入记录
	 *
	 * @param recordDO 信息
	 * @return int
	 * @author zwq
	 * @date 2022/4/18 17:13
	 */
	@Override
	public int insertRecord(RecordDO recordDO) {
		log.info("Seata全局事务id=================>{}", RootContext.getXID());
		com.zzz.pped.test.pojo.dos.RecordDO target = new com.zzz.pped.test.pojo.dos.RecordDO();
		BeanUtils.copyProperties(recordDO, target);
		return recordMapper.insert(target);
	}
}
