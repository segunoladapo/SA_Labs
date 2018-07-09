package edu.mum.sa.lab.customerapp.CustomerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppApplication.class, args);
	}
}
