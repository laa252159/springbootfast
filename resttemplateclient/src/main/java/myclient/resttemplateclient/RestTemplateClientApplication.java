package myclient.resttemplateclient;

import client.model.Payment;
import client.restclient.PaymentProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class RestTemplateClientApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(RestTemplateClientApplication.class, args);
        PaymentProxy paymentProxy = context.getBean(PaymentProxy.class);

        for (int i = 0; i < 10; i++) {
            paymentProxy.creatPayment(new Payment(UUID.randomUUID().toString(), 987));
            Thread.sleep(5000);
        }


    }

}
