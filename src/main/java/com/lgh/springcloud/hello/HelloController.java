package com.lgh.springcloud.hello;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		return "hello world, Johnson";
	}
	
}
