package com.mike.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.mike.configrule.MyRibbonRule;
/**
 * 服务的消费者
 * @author asus
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="SPRINGCLOUDDEMO-DEPT",configuration=MyRibbonRule.class) // 设置自定义的Ribbon 负载均衡策略
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
