package com.lgh.springcloud.hello.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgh.springcloud.hello.service.api.dto.User;
import com.lgh.springcloud.hello.service.api.service.HelloService;

@RestController
public class RefactorHelloController implements HelloService {

	@Override
	public String hello(@RequestParam("name") String name) {
		return "Hello " + name;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		return new User(name, age);
	}

	@Override
	public String hello(@RequestBody User user) {
		return "Hello" + user.getName() + ", " + user.getAge();
	}

}
