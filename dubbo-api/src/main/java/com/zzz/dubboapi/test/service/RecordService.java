package com.zzz.dubboapi.test.service;


import com.zzz.dubboapi.test.pojo.dos.RecordDO;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:09
 */
public interface RecordService {

	/**
	 * description: 更新信息
	 * @author zwq
	 * @date 2022/4/18 15:10
	 * @param recordDO 信息
	 * @return int
	 */
	int updateRecord(RecordDO recordDO);

	/**
	 * description: 插入记录
	 * @author zwq
	 * @date 2022/4/18 17:13
	 * @param recordDO 信息
	 * @return int
	 */
	int insertRecord(RecordDO recordDO);

}
