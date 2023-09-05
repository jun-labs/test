package project.test.singleinstance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingleInstanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleInstanceApplication.class, args);
    }

}
