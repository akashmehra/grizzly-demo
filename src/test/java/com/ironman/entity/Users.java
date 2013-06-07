package com.ironman.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users implements BaseTestCase<User>{

    @XmlElement(name="user")
    private List<User> users;
    public Users() {
        
    }
    
    public List<User> getList() {
        return this.users;
    }
    
}
