package com.zero.Shopsphere.MicroService1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

}
@RestController
@RequestMapping("/micro1")
class Micro1Controller {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from microservice1!";
	}
}