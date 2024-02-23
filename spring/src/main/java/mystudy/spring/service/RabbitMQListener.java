package mystudy.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);
    @RabbitListener(bindings = @QueueBinding(value=@Queue(value = "create_pdf_queue", durable = "false"),exchange = @Exchange(value = "pdf_events"), key = "create_pdf"))
    public  void receiver(CreatePdfEvent createPdfEvent){
        logger.info("Received message -> {}",createPdfEvent.getFileName());

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "user.queue", durable = "false"), exchange = @Exchange(value = "user.exchange", type = "topic"), key = "user.#"))
    public void userReceiver(UserResetEvent userResetEvent){
        logger.info("Received User Message -> {}", userResetEvent.getUsername());
    }
}

