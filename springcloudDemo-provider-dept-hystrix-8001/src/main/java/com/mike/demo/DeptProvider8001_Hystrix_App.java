package com.mike.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务的提供者
 * @author asus
 *
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker//对hystrix 熔断机制的支持
public class DeptProvider8001_Hystrix_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
  }
}