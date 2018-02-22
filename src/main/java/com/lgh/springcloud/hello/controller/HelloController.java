package com.lgh.springcloud.hello.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgh.springcloud.hello.service.api.dto.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	@Autowired
	private Registration reg;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {
		//int sleepTime = new Random().nextInt(3000);
		int sleepTime = new Random().nextInt(30);
		log.info("sleepTime: {}", sleepTime);
		Thread.sleep(sleepTime);

		if (reg != null) {
			log.info("Registration, host={}, port={}, uri={}, isSecure={}, serviceId={}, meta={}", reg.getHost(),
					reg.getPort(), reg.getUri(), reg.isSecure(), reg.getServiceId(), reg.getMetadata());
		}
		return "hello world, Johnson";
	}
	
	@RequestMapping(value="/hello1", method=RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		return new User(name, age);
	}

	@RequestMapping(value="/hello3", method=RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello " + user.getName() + ", " + user.getAge();
	}
}
