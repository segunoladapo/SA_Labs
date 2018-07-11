package edu.mum.sa.lab.reactive.reactiveassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReactiveAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveAssignmentApplication.class, args);
	}
}
