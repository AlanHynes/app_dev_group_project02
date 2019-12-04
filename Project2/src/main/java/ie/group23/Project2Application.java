package ie.group23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Project2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
