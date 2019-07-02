package com.mike.configrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义 Ribbon 负载均衡算法
 * 由于Ribbon 规定，自定义Rule 不能放在@@ComponentScan下，
 * 所以在该项目，Ribbon 不能放在主启动类的所在包和其子包下。 
 * P: 主启动类 com.mike.demo 当前Rule 设置为 com.mike.configrule
 * 并在主启动类下使用 @RibbonClient(name="服务名称",configuration=MyRibbonRule.class)
 *
 */
@Configuration
public class MyRibbonRule {
	@Bean
	public IRule myRibbonRule () {
		return new RandomRule();
	}
}
