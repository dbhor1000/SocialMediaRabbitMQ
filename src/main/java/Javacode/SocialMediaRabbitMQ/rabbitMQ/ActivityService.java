package Javacode.SocialMediaRabbitMQ.rabbitMQ;

import Javacode.SocialMediaRabbitMQ.model.Comment;
import Javacode.SocialMediaRabbitMQ.model.Like;
import Javacode.SocialMediaRabbitMQ.model.Publication;
import Javacode.SocialMediaRabbitMQ.repository.PublicationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private final PublicationRepository publicationRepository;

    public ActivityService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }


    @RabbitListener(queues = "new_likes")
    public void handleLike(Like like) {
        // Lookup publication in the database
        Publication publication = publicationRepository.findById(like.getLikedPublicationId()).orElse(null);
        if (publication != null) {
            String notificationMessage1 = "User " + like.getLikeByUsername() + " liked " + publication.getMessage() + " by " + publication.getPublishedByUsername();
            System.out.println("Sending like notification to subscribers of " + publication.getTag() + ": " + notificationMessage1);
            String notificationMessage2 = "To user " + publication.getPublishedByUsername() + ": " + publication.getMessage() + " received a new like from "
                    + like.getLikeByUsername();
            System.out.println(notificationMessage2);
            // Send notification to the user
        }
    }

    @RabbitListener(queues = "new_comments")
    public void handleComment(Comment comment) {
        // Lookup publication in the database
        Publication publication = publicationRepository.findById(comment.getCommentedOnPublicationId()).orElse(null);
        if (publication != null) {
            String notificationMessage1 = "User " + comment.getCommentByUsername() + " commented on " + publication.getMessage() + " by " + publication.getPublishedByUsername() + ": " + comment.getCommentText();
            System.out.println("Sending comment notification to subscribers of " + publication.getTag() + ": " + notificationMessage1);
            String notificationMessage2 = "To user " + publication.getPublishedByUsername() + ": " + publication.getMessage() +
                    " received a new comment from " + comment.getCommentByUsername();
            System.out.println(notificationMessage2);
            // Send notification to the user
        }
    }
}