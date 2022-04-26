package com.zzz.ppedapi.config;


import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义权重
 *
 * @author zwq
 * @version 1.0.0
 * @Date 2022/4/15
 */
@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {

	@Autowired
	private NacosDiscoveryProperties nacosDiscoveryProperties;

	/**
	 * 读取配置文件，并初始化NacosWeightedRule
	 *
	 * @param iClientConfig iClientConfig
	 */
	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {
		// do nothing
	}

	@Override
	public Server choose(Object key) {
		BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();

		// 需要请求的微服务名称
		String name = loadBalancer.getName();
		// 获取服务发现的相关API
		NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
		String group = nacosDiscoveryProperties.getGroup();
		try {
			// 调用该方法时nacos client会自动通过基于权重的负载均衡算法选取一个实例
			Instance instance = namingService.selectOneHealthyInstance(name, group, true);
			log.info("=============invoke serviceName:{}, ip:{}, port:{}", instance.getServiceName(), instance.getIp(), instance.getPort());
			return new NacosServer(instance);
		} catch (NacosException e) {
			return null;
		}
	}

}

