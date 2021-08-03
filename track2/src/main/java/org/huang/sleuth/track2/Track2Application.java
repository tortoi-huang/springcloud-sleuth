package org.huang.sleuth.track2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Track2Application {

	public static void main(String[] args) {
		SpringApplication.run(Track2Application.class, args);
	}

}
