package com.mike.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mike.demo.entities.Dept;

import feign.hystrix.FallbackFactory;
/**
 * 将Service 下的方法定义一个fallback 当出现异常的时候，Service进行调用返回
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long id) {
				// TODO Auto-generated method stub
				return new Dept(id,"该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭","no this database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
