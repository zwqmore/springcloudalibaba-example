package com.zzz.pped.test.pojo.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:07
 */
@Data
@TableName("user_good")
public class UserGoodDO implements Serializable {

	private static final long serialVersionUID = -8443249254304644736L;

	@TableId("ug_id")
	private Integer id;

	@TableField("ug_user_id")
	private Integer userId;

	@TableField("ug_good_id")
	private Integer goodId;

}
