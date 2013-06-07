package com.ironman.exceptions;

@SuppressWarnings("serial")
public class XMlSerializationException extends Exception {

    public XMlSerializationException() {
        super();
    }
    
    public XMlSerializationException(String msg) {
        super(msg);
    }
    
    public XMlSerializationException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    
    public XMlSerializationException(Throwable throwable) {
        super(throwable);
    }
    
}
