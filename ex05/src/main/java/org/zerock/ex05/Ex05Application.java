package org.zerock.ex05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //감시 활성화
public class Ex05Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}

}
