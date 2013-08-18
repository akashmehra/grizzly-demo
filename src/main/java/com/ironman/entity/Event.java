package com.ironman.entity;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ironman.exceptions.XMlSerializationException;


@Table(name="event")
@XmlRootElement(name="event")
@XmlType(propOrder={"eventId","eventName","images","comments","likes"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Event implements MetaDataEntity {
    
    private final UUID eventId;
    private String eventName;
    private List<Image> images;
    private List<Comment> comments;
    private List<User> likes;

    public Event() {
        eventId = UUID.randomUUID();
    }
    
    public UUID getEventId() {
        return eventId;
    }
    
    public String getEventName() {
        return eventName;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }


    public String getTableName() {
        // TODO Auto-generated method stub
        return null;
    }

    public String toXml() throws XMlSerializationException {
        // TODO Auto-generated method stub
        return null;
    }

}
