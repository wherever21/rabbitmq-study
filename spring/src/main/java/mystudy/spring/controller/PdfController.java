package mystudy.spring.controller;

import mystudy.spring.service.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

    private final RabbitMQProducer rabbitMQProducer;

    public PdfController(RabbitMQProducer rabbitMQProducer){
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(){
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }


    @GetMapping("/users/publish")
    public ResponseEntity<String> sendUserMessage(){
        rabbitMQProducer.userInfoSend("mkang@makeflow.co.kr");
        return ResponseEntity.ok("User Message sent to RabbitMQ...");
    }

    @GetMapping("/test/publish")
    public ResponseEntity<String> sendTestMessage(String message){
        rabbitMQProducer.sentTest(message);
        return ResponseEntity.ok("Test Message sent to RabbitMQ ...");
    }
}
