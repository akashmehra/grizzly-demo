package com.ironman.com.DataEngine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Events")
public class Events {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String eventName() {
        return "default event";
    }
}
