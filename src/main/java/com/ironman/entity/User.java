
package com.ironman.entity;

import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ironman.exceptions.EntityParseException;
import com.ironman.exceptions.XMlSerializationException;


@Table(name="user")
@XmlRootElement(name="user")
@XmlType(propOrder={"userId","username","firstname","lastname","location"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class User implements MetaDataEntity {
    
    @XmlElement
    private final UUID userId;
    private String username;
    private String firstname;
    private String lastname;
    private Location location;
    
    public User() {
        userId = UUID.randomUUID();
    }
    
    public UUID getUserId() {
        return userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getFirstname() {
        return firstname;
    }
   
    public String getLastname() {
        return lastname;
    }
   
    public Location getLocation() {
        return location;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
        
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", username=");
        builder.append(username);
        builder.append(", firstname=");
        builder.append(firstname);
        builder.append(", lastname=");
        builder.append(lastname);
        builder.append(", location=");
        builder.append(location);
        builder.append("]");
        return builder.toString();
    }
    
    public Map<String,String> getEntityAsMap() throws EntityParseException {
       Map<String,String> map = new HashMap<String, String>();
       try {
       for(Method m : this.getClass().getDeclaredMethods()) {
           
           Column column = m.getAnnotation(Column.class);
           if(column != null) {
               map.put(column.name(), m.invoke(this, (Object)null).toString());
           }
       }
       } catch(Exception e) {
           throw new EntityParseException("Error creating map for Entity User");
       }
       return map;
    }
    
    public String toXml() throws XMlSerializationException {
        Writer writer = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.marshal(this, writer);
        } catch (JAXBException ex) {
            throw new XMlSerializationException("Error serializaing user entity to xml.");
        }
        return writer.toString();
    }
    
    public String getTableName() {
       return this.getClass().getAnnotation(Table.class).name();
    }
    
}
