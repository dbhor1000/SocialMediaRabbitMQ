package Javacode.SocialMediaRabbitMQ.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "publication_table")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publicationId;
    @Column(name = "publication_tag")
    private String tag;
    @Column(name = "publication_message")
    private String message;
    @Column(name = "publication_by_username")
    private String publishedByUsername;

    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPublishedByUsername() {
        return publishedByUsername;
    }

    public void setPublishedByUsername(String publishedByUsername) {
        this.publishedByUsername = publishedByUsername;
    }
}