package Pharmachain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PharmachainApplication {
	public static void main(String[] args) {
		SpringApplication.run(PharmachainApplication.class, args);
	}
}