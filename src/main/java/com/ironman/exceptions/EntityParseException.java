package com.ironman.exceptions;

@SuppressWarnings("serial")
public class EntityParseException extends Exception {
    
    public EntityParseException() {
        super();
    }
    
    public EntityParseException(String msg) {
        super(msg);
    }
    
    public EntityParseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    
    public EntityParseException(Throwable throwable) {
        super(throwable);
    }
}
