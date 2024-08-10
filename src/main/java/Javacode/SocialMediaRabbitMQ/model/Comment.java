package Javacode.SocialMediaRabbitMQ.model;

import jakarta.persistence.*;

@Entity(name = "comment_table")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    @Column(name = "commented_on_publication_id")
    private Long commentedOnPublicationId;
    @Column(name = "comment_from")
    private String commentByUsername;
    @Column(name = "comment_text")
    private String commentText;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentedOnPublicationId() {
        return commentedOnPublicationId;
    }

    public void setCommentedOnPublicationId(Long commentedOnPublicationId) {
        this.commentedOnPublicationId = commentedOnPublicationId;
    }

    public String getCommentByUsername() {
        return commentByUsername;
    }

    public void setCommentByUsername(String commentByUsername) {
        this.commentByUsername = commentByUsername;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}