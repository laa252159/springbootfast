package controllers;


import model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> creatPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        logger.info("Received request with ID " + requestId + " ;Payment amount: " + payment.getAmount());
        return ResponseEntity
                .status(200)
                .header("requestId", requestId)
                .body(payment);
    }

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        logger.info("Received request ");
        return ResponseEntity
                .status(200)
                .header("requestId", "123")
                .body("Hello home page");
    }

}
