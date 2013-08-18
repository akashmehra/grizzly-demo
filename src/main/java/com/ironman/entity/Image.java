package com.ironman.entity;

import java.util.UUID;

import javax.imageio.metadata.IIOMetadata;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ironman.exceptions.XMlSerializationException;

@Table(name="image")
@XmlRootElement(name="image")
@XmlType(propOrder={"userId","username","firstname","lastname","location"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Image implements MetaDataEntity {
    
    private final UUID imageId;
    private String imageName;
    private String imagePath;
    private IIOMetadata imageMetadata;
    
    public Image() {
        imageId = UUID.randomUUID();
    }
    
    public UUID getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public IIOMetadata getImageMetadata() {
        return imageMetadata;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageMetadata(IIOMetadata imageMetadata) {
        this.imageMetadata = imageMetadata;
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
