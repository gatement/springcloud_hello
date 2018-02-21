package com.lgh.springcloud.hello;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	@Autowired
	private Registration reg;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {
		int sleepTime = new Random().nextInt(3000);
		log.info("sleepTime: {}", sleepTime);
		Thread.sleep(sleepTime);

		if (reg != null) {
			log.info("Registration, host={}, port={}, uri={}, isSecure={}, serviceId={}, meta={}", reg.getHost(),
					reg.getPort(), reg.getUri(), reg.isSecure(), reg.getServiceId(), reg.getMetadata());
		}
		return "hello world, Johnson";
	}

}
