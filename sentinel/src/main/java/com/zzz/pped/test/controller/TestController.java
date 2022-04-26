package com.zzz.pped.test.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.zzz.dubboapi.test.service.UserService;
import com.zzz.pped.test.service.SeataService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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

	@DubboReference
	private UserService userService;

	private final SeataService seataService;

	@Value("${local.server.port}")
	private int port;

	private final NacosConfigManager nacosConfigManager;

	private final Environment environment;

	@Value("${msg.content}")
	String content;

	@Value("${msg.time}")
	String time;

	@Value("${user.username}")
	String userName;

	@Value("${user.pass}")
	String pass;

	@GetMapping("test")
	public String test() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(userName + " ").append(pass + " ");
		stringBuilder.append(content + " ").append(time + " ");
		System.out.println(nacosConfigManager.getConfigService());
		System.out.println(nacosConfigManager.getNacosConfigProperties());
		System.out.println(environment.getProperty("pped-ok.yml"));
		System.out.println(environment.getProperty("pped-test"));
		return stringBuilder.toString() + port;
	}

	@GetMapping("dubbo")
	public String dubboTest() {
		return userService.getString();
	}

	@GetMapping("seata")
	public String seata() {
		return seataService.test();
	}

}
