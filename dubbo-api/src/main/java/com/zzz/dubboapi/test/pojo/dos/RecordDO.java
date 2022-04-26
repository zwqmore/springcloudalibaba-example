package com.zzz.dubboapi.test.pojo.dos;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:08
 */
@Data
public class RecordDO implements Serializable {

	private static final long serialVersionUID = 2110929094984107751L;

	private Integer id;

	private Integer userId;

	private Integer goodId;

	private String content;

	private Date createTime;

}
