package Javacode.SocialMediaRabbitMQ.rabbitMQ;

import Javacode.SocialMediaRabbitMQ.model.PublicationDeliverTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationsService.class);

    @RabbitListener(queues = "new_notifications")
    public void handleNotification(PublicationDeliverTo publicationDeliverTo) {
        // Logic to send notifications to subscribers
        logger.info("Sending notification to: " + publicationDeliverTo.getDeliverTo());
        logger.info("Publication: " + publicationDeliverTo.getMessage());
    }
}