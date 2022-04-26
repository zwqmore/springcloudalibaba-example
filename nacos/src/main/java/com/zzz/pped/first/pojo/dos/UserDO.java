package com.zzz.pped.first.pojo.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/11 15:40
 */
@Data
@TableName("user")
public class UserDO implements Serializable {

	private static final long serialVersionUID = 230648059047921755L;

	@TableId("user_id")
	private Integer id;

	@TableField("user_name")
	private String name;

	@TableField("user_gold")
	private BigDecimal gold;

}
