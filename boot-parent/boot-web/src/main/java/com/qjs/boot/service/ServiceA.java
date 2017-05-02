package com.qjs.boot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qjs.boot.config.FooConfiguration;

/**
 * 
 * @author qianjs163@163.com
 *
 * @since 2016年11月30日
 */

@FeignClient(name = "boot-rabbitmq", fallback = HelloServiceFallback.class, configuration = FooConfiguration.class)
public interface ServiceA {

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	String hello();

	@RequestMapping(value = "/hello/h1/{id}", method = RequestMethod.GET)
	String hello(@PathVariable(value = "id") String id);
}
