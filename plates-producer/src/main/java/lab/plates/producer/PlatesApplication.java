package lab.plates.producer;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlatesApplication {
	@Generated
	public static void main(String[] args) {
		SpringApplication.run(PlatesApplication.class, args);
	}


}

