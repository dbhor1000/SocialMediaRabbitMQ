package Javacode.SocialMediaRabbitMQ.repository;

import Javacode.SocialMediaRabbitMQ.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
