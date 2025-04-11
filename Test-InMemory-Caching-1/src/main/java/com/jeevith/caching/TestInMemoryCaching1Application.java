package com.jeevith.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestInMemoryCaching1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestInMemoryCaching1Application.class, args);
	}

}
	