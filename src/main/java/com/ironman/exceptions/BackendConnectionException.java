package com.ironman.exceptions;

@SuppressWarnings("serial")
public class BackendConnectionException extends Exception {

    public BackendConnectionException() {
        super();
    }
    
    public BackendConnectionException(String msg) {
        super(msg);
    }
    
    public BackendConnectionException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    
    public BackendConnectionException(Throwable throwable) {
        super(throwable);
    }
    
}
