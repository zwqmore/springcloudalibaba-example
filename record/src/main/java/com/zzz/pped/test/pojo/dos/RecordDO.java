package com.zzz.pped.test.pojo.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:08
 */
@Data
@TableName("record")
public class RecordDO implements Serializable {

	private static final long serialVersionUID = 2110929094984107751L;

	@TableId("record_id")
	private Integer id;

	@TableField("record_user_id")
	private Integer userId;

	@TableField("record_good_id")
	private Integer goodId;

	@TableField("record_content")
	private String content;

	@TableField("create_time")
	private Date createTime;

}
