package com.zzz.dubboapi.test.pojo.dos;

import java.io.Serializable;


import lombok.Data;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/4/18 15:07
 */
@Data
public class UserGoodDO implements Serializable {

	private static final long serialVersionUID = -8443249254304644736L;

	private Integer id;

	private Integer userId;

	private Integer goodId;

}
