package Javacode.SocialMediaRabbitMQ.repository;

import Javacode.SocialMediaRabbitMQ.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
