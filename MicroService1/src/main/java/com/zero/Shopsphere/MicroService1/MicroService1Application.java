package com.zero.Shopsphere.MicroService1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

}
@RestController
@RequestMapping("/m1")
class  Micro1Controller {
	private static final Logger log = LoggerFactory.getLogger(Micro1Controller.class);

	@GetMapping("/test")
	public String sayHello() {
		System.out.println("Hello from microservice1!");
		Random random = new Random();
		int delaySeconds = random.nextInt(10) + 1; // 1 to 10
		log.info("Received request for /test endpoint. Will delay for {} seconds.", delaySeconds);

		try {
			Thread.sleep(delaySeconds * 1000L);
		} catch (InterruptedException e) {
			log.error("Thread was interrupted during simulated delay", e);
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		}

		if (delaySeconds % 2 == 0) {
			log.error("Test failed");

		} else {
			log.info("Test sucess");

		}
		return "Success from microservice1!";
	}
}