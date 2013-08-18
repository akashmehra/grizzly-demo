package com.ironman.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.junit.Before;
import org.junit.Test;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class ImageTest {
    
    private Image image = null;
    
    @Before
    public void setUp() {
        image = new Image();
    }
    
    @Test
    public void testExifInfoReader() throws FileNotFoundException, IOException, ImageProcessingException {
        ImageReader imgReader = ImageIO.getImageReadersBySuffix("jpg").next();
        System.out.println(UUID.randomUUID());
        ImageInputStream imgInputStream = new FileImageInputStream(new File("src/test/java/image.jpg"));
        Metadata metadata = ImageMetadataReader.readMetadata(new File("src/test/java/image.jpg"));
        StringBuilder sb = new StringBuilder();
        Iterator<Directory> iter = metadata.getDirectoryIterator();
        while(iter.hasNext()) {
            Iterator<Tag> tagIter = iter.next().getTagIterator();
            while(tagIter.hasNext()) {
                Tag tag = tagIter.next();
                sb.append(tag);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        
    }

}
