package com.demo.barogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BarogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarogoApplication.class, args);
	}

}
