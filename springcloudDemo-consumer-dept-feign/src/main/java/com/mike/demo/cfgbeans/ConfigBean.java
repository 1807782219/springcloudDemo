package com.mike.demo.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean // 之前使用的是Spring的 applicationContext.xml
{
    @Bean
    @LoadBalanced // SpringCloud Ribbon 客户端负载均衡 开启
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
    
    /**
 	设置Ribbon的负载均衡策略（默认是轮询）
     	- RoundRobinRule
		  轮询 默认
		- RandomRule
		  随机
		- AvailabilityFilteringRule
		  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
		  还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
		- WeightedResponseTimeRule
		  根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
		  刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，
		  会切换到WeightedResponseTimeRule
		- RetryRule
		  先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
		- BestAvailableRule
		  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
		- ZoneAvoidanceRule
		  默认规则,复合判断server所在区域的性能和server的可用性选择服务器  
     */
    @Bean
    public IRule myRule() {
    	return new RandomRule();
    }
}