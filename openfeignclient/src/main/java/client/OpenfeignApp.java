package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenfeignApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignApp.class, args);
        System.out.println("Hello world!");
    }
}