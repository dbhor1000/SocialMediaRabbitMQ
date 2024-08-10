package Javacode.SocialMediaRabbitMQ.repository;

import Javacode.SocialMediaRabbitMQ.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
