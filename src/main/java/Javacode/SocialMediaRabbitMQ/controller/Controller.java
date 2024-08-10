package Javacode.SocialMediaRabbitMQ.controller;

import Javacode.SocialMediaRabbitMQ.model.Comment;
import Javacode.SocialMediaRabbitMQ.model.Like;
import Javacode.SocialMediaRabbitMQ.model.Publication;
import Javacode.SocialMediaRabbitMQ.rabbitMQ.PublicationService;
import Javacode.SocialMediaRabbitMQ.repository.CommentRepository;
import Javacode.SocialMediaRabbitMQ.repository.LikeRepository;
import Javacode.SocialMediaRabbitMQ.repository.PublicationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final PublicationService publicationService;
    private final RabbitTemplate rabbitTemplate;

    public Controller(PublicationRepository publicationRepository, LikeRepository likeRepository, CommentRepository commentRepository, PublicationService publicationService, RabbitTemplate rabbitTemplate) {
        this.publicationRepository = publicationRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.publicationService = publicationService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/newPublication")
    public ResponseEntity<Publication> newPublication(@RequestBody Publication publication) {

        publicationService.publishToQueue(publication);
        publicationRepository.save(publication);
        return ResponseEntity.ok(publication);
    }

    @PostMapping("/newComment")
    public ResponseEntity<Comment> newComment(@RequestBody Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        rabbitTemplate.convertAndSend("new_comments", savedComment);
        return ResponseEntity.ok(savedComment);
    }

    @PostMapping("/newLike")
    public ResponseEntity<Like> newLike(@RequestBody Like like) {
        Like savedLike = likeRepository.save(like);
        rabbitTemplate.convertAndSend("new_likes", savedLike);
        return ResponseEntity.ok(savedLike);
    }
}
