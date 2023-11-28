package org.zerock.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //감시 활성화
public class Ex04Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex04Application.class, args);
	}

}
