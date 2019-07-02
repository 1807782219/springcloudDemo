package com.mike.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/**
 * 使用 Feign 服务的消费者
 * @author asus
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 添加Feign 使用注解
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
