package Javacode.SocialMediaRabbitMQ.model;

import jakarta.persistence.*;

@Entity(name = "like_table")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeId;
    @Column(name = "commented_on_publication_id")
    private Long likedPublicationId;
    @Column(name = "like_from")
    private String likeByUsername;

    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
    }

    public Long getLikedPublicationId() {
        return likedPublicationId;
    }

    public void setLikedPublicationId(Long likedPublicationId) {
        this.likedPublicationId = likedPublicationId;
    }

    public String getLikeByUsername() {
        return likeByUsername;
    }

    public void setLikeByUsername(String likeByUsername) {
        this.likeByUsername = likeByUsername;
    }
}