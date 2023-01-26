package client.openfeign;

import client.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment creatPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
