package com.zzz.dubboapi.test.pojo.dos;

import java.io.Serializable;
import java.math.BigDecimal;


import lombok.Data;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:06
 */
@Data
public class GoodDO implements Serializable {

	private static final long serialVersionUID = -9057472733161529004L;

	private Integer id;

	private String name;

	private BigDecimal price;

}
