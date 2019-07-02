package com.mike.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
 
@SpringBootApplication
@EnableHystrixDashboard //开启  Hystrix 监控
public class DeptConsumer_DashBoard_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer_DashBoard_App.class,args);
  }
}
