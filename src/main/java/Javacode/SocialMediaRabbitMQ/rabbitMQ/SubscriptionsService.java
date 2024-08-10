package Javacode.SocialMediaRabbitMQ.rabbitMQ;

import Javacode.SocialMediaRabbitMQ.model.Publication;
import Javacode.SocialMediaRabbitMQ.model.PublicationDeliverTo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionsService {

    private final RabbitTemplate rabbitTemplate;

    public SubscriptionsService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "new_publications")
    public void handlePublication(Publication publication) {
        // Determine subscribers based on the tag
        String deliverTo = "Deliver to subscribers of: " + publication.getTag();
        PublicationDeliverTo publicationDeliverTo = new PublicationDeliverTo(
                publication.getPublicationId(),
                publication.getTag(),
                publication.getMessage(),
                publication.getPublishedByUsername(),
                deliverTo
        );

        // Send to notifications queue
        rabbitTemplate.convertAndSend("уведомления_подписчикам", publicationDeliverTo);
    }
}