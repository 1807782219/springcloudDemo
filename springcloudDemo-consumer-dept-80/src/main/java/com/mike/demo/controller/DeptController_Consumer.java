package com.mike.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mike.demo.entities.Dept;

@RestController
public class DeptController_Consumer {
	// private static final String REST_URL_PREFIX="http://localhost:8001/dept";
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUDDEMO-DEPT"; // 修改服务的调用路径，通过服务名称进行访问
	@Autowired
	private RestTemplate restTemplate;
	/**
	 * RestTemplate 类似 JDBCTemplate 提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问Restful服务
	 * 模板类，是Spring 提供的用于访问Rest 服务的客户端模板工具集 GET POST PUT DELETE 
	 * （url，requestMap，ResponseBean.class）
	 * REST 请求地址，请求参数， HTTP响应转换被转换的对象类型
	 */
	@PostMapping("/consumer/dept/add")
	public Boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id, Dept.class);
	}
	
	@GetMapping("/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
}
