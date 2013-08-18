package com.ironman.entity;

import com.ironman.exceptions.XMlSerializationException;


public interface MetaDataEntity {
    public String getTableName();
    public String toXml() throws XMlSerializationException;
}
