package com.zzz.pped.test.pojo.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:06
 */
@Data
@TableName("good")
public class GoodDO implements Serializable {

	private static final long serialVersionUID = -9057472733161529004L;

	@TableId("good_id")
	private Integer id;

	@TableField("good_name")
	private String name;

	@TableField("price")
	private BigDecimal price;

}
