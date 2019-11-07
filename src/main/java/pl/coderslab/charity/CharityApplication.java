package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CharityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(CharityApplication.class, args);

    }



}
