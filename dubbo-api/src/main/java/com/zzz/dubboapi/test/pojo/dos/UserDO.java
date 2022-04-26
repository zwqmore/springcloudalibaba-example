package com.zzz.dubboapi.test.pojo.dos;

import java.io.Serializable;
import java.math.BigDecimal;


import lombok.Data;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/11 15:40
 */
@Data
public class UserDO implements Serializable {

	private static final long serialVersionUID = 230648059047921755L;

	private Integer id;

	private String name;

	private BigDecimal gold;

}
