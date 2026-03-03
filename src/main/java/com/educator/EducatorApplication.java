package com.educator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EducatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducatorApplication.class, args);
	}

}
