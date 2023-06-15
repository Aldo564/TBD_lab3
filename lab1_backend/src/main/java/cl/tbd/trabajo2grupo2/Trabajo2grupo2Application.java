package cl.tbd.trabajo2grupo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
//@EnableMongoRepositories
public class Trabajo2grupo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabajo2grupo2Application.class, args);
	}
}
