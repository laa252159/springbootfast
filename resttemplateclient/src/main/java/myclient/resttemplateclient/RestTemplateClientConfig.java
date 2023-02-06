package myclient.resttemplateclient;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"client.restclient"})
@SpringBootConfiguration
public class RestTemplateClientConfig {

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }

}
