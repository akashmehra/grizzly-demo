package com.ironman.entity;

import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.PROPERTY)
public class Comment {

    private final UUID commentId;
    private User user;
    private String comment;
    
    public Comment() {
        commentId = UUID.randomUUID();
    }
    
    public UUID getcommentId() {
        return commentId;
    }
    
    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment [user=" + user + ", comment=" + comment + "]";
    }

}
