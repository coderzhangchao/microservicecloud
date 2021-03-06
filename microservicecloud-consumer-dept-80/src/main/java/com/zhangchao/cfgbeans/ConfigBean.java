package com.zhangchao.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	/**
	 * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	/**
	 * 自定义路由规则，将轮训改为随机
	 * @return
	 */
	@Bean
	public IRule myRule()
	{
		return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
	}
}
