package Javacode.SocialMediaRabbitMQ.model;

import java.io.Serializable;

public class PublicationDeliverTo implements Serializable {

    private long publicationId;
    private String tag;
    private String message;
    private String publishedByUsername;
    private String deliverTo;

    public PublicationDeliverTo(long publicationId, String tag, String message, String publishedByUsername, String deliverTo) {
        this.publicationId = publicationId;
        this.tag = tag;
        this.message = message;
        this.publishedByUsername = publishedByUsername;
        this.deliverTo = deliverTo;
    }

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

    public String getDeliverTo() {
        return deliverTo;
    }

    public void setDeliverTo(String deliverTo) {
        this.deliverTo = deliverTo;
    }
}