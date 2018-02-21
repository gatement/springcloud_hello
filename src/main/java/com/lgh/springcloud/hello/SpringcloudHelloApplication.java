package com.lgh.springcloud.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudHelloApplication.class, args);
	}
	
}
