package mystudy.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String fileName) {
        CreatePdfEvent event = new CreatePdfEvent(fileName, 100, "http://localhost:1212/".concat(fileName));
        logger.info("Message Sent -> {}", fileName);
        rabbitTemplate.convertAndSend("pdf_events","create_pdf", event);
    }

    public void userInfoSend(String username){
        UserResetEvent event = new UserResetEvent(username, "11111");
        logger.info("User Message Sent -> {}", username);
        rabbitTemplate.convertAndSend("user.exchange", "user.reset.event", event);
    }
}
