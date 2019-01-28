package fr.Orantoine.APIJAVA;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class ApiJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJavaApplication.class, args);
	}

}

