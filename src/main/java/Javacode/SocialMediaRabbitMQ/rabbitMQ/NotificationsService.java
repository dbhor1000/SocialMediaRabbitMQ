package Javacode.SocialMediaRabbitMQ.rabbitMQ;

import Javacode.SocialMediaRabbitMQ.model.PublicationDeliverTo;
import Javacode.SocialMediaRabbitMQ.repository.PublicationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {

//    private final PublicationRepository publicationRepository;
//
//    public NotificationsService(PublicationRepository publicationRepository) {
//        this.publicationRepository = publicationRepository;
//    }

    @RabbitListener(queues = "уведомления_подписчикам")
    public void handleNotification(PublicationDeliverTo publicationDeliverTo) {
        // Logic to send notifications to subscribers
        System.out.println("Sending notification to: " + publicationDeliverTo.getDeliverTo());
        System.out.println("Publication: " + publicationDeliverTo.getMessage());
    }

//    @RabbitListener(queues = "new_likes")
//    public void handleLike(Like like) {
//        // Lookup publication in the database
//        Publication publication = publicationRepository.findById(like.getLikedPublicationId()).orElse(null);
//        if (publication != null) {
//            String notificationMessage = "User " + like.getLikeByUsername() + " liked " + publication.getMessage() + " by " + publication.getPublishedByUsername();
//            System.out.println("Sending like notification to subscribers of " + publication.getTag() + ": " + notificationMessage);
//            // Send notification to subscribers
//        }
//    }
//
//    @RabbitListener(queues = "new_comments")
//    public void handleComment(Comment comment) {
//        // Lookup publication in the database
//        Publication publication = publicationRepository.findById(comment.getCommentedOnPublicationId()).orElse(null);
//        if (publication != null) {
//            String notificationMessage = "User " + comment.getCommentByUsername() + " commented on " + publication.getMessage() + " by " + publication.getPublishedByUsername() + ": " + comment.getCommentText();
//            System.out.println("Sending comment notification to subscribers of " + publication.getTag() + ": " + notificationMessage);
//            // Send notification to subscribers
//        }
//    }
}