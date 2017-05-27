package com.qjs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import com.qjs.properties.CommonProperties;

/**
 * 
 * @author qianjs163@163.com
 *
 */
// @EnableDiscoveryClient
@SpringBootApplication
// @EnableFeignClients
@EnableConfigurationProperties({ CommonProperties.class })
@EnableCircuitBreaker
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
