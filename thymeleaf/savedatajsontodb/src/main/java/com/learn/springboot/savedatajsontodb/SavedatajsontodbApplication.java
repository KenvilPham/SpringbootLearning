package com.learn.springboot.savedatajsontodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SavedatajsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavedatajsontodbApplication.class, args);
	}

}
