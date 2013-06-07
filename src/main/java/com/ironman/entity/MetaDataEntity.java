package com.ironman.entity;

import com.ironman.exceptions.XMlSerializationException;


public interface MetaDataEntity {

    //public Map<String,String> getEntityAsMap() throws EntityParseException;
    public String getTableName();
    public String toXml() throws XMlSerializationException;
}
