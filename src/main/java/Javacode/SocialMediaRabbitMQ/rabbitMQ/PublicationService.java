package Javacode.SocialMediaRabbitMQ.rabbitMQ;

import Javacode.SocialMediaRabbitMQ.model.Publication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {

    private final RabbitTemplate rabbitTemplate;

    public PublicationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishToQueue(Publication publication) {
        rabbitTemplate.convertAndSend("new_publications", publication);
    }
}