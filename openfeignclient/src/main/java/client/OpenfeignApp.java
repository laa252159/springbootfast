package client;

import client.model.Payment;
import client.openfeign.PaymentProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class OpenfeignApp {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(OpenfeignApp.class, args);
        PaymentProxy paymentProxy = context.getBean(PaymentProxy.class);
        Payment payment = new Payment(UUID.randomUUID().toString(), 444);
        Arrays.stream(context.getBeanNamesForType(PaymentProxy.class)).sequential().forEach(System.out::println);
        for (int i = 0; i < 10; i++) {
            paymentProxy.creatPayment(UUID.randomUUID().toString(), payment);
            Thread.sleep(1000);
        }

    }
}