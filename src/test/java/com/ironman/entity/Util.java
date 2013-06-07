package com.ironman.entity;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@SuppressWarnings("unchecked")
public class Util<T,U extends T> {

    public T unmarshalFromXml(String filePath, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T)unmarshaller.unmarshal(new File(filePath));
    }
    
    public void testMe(List<? extends T> list) {
        System.out.println(list);
    }
    
}
