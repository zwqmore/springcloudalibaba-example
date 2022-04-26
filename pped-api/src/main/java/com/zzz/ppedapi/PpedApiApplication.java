package com.zzz.ppedapi;

import com.netflix.loadbalancer.IRule;
import com.zzz.ppedapi.config.NacosWeightedRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PpedApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpedApiApplication.class, args);
	}

	@Bean
	public IRule loadBalanceRule(){
		return new NacosWeightedRule();
	}

}
