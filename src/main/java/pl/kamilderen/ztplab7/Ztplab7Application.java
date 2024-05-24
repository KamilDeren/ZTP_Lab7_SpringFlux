package pl.kamilderen.ztplab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kamilderen.ztplab7.model.Order;

@SpringBootApplication
public class Ztplab7Application {

	public static void main(String[] args) {
		Order.setCounter(0);
		SpringApplication.run(Ztplab7Application.class, args);
	}

}
