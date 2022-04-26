package com.zzz.pped.first.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.zzz.dubboapi.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 测试
 *
 * @author zwq
 * @date 2022/4/11 15:50
 */
@RestController
@RequiredArgsConstructor
@RefreshScope
public class TestController {

	private final NacosConfigManager nacosConfigManager;

	private final Environment environment;

	private final UserService userService;

	@Value("${local.server.port}")
	private int port;


	@Value("${user.username}")
	String userName;

	@Value("${user.pass}")
	String pass;

	@GetMapping("test")
	public String test() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(userName + " ").append(pass + " ");
		System.out.println(nacosConfigManager.getConfigService());
		System.out.println(nacosConfigManager.getNacosConfigProperties());
		System.out.println(environment.getProperty("pped-ok.yml"));
		System.out.println(environment.getProperty("pped-test"));
		return stringBuilder.toString() + " port:" + port;
	}

	@GetMapping("get/user")
	public String getUserName() {
		return userService.getUser(1).toString();
	}

}
