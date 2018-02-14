package com.lgh.springcloud.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@EnableDiscoveryClient
@RestController
@Slf4j
public class HelloController {
	@Autowired
	private Registration reg;

	@RequestMapping("/hello")
	public String index() {
		if (reg != null) {
			log.info("Registration, host={}, port={}, uri={}, isSecure={}, serviceId={}, meta={}", reg.getHost(),
					reg.getPort(), reg.getUri(), reg.isSecure(), reg.getServiceId(), reg.getMetadata());
		}
		return "hello world, Johnson";
	}

}
