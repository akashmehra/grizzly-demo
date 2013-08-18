package com.code.Jarvis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.code.entity.User;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    
    private static final String FILENAME = "store.txt";
    private static Logger log = Logger.getLogger(MyResource.class.getName());

    public MyResource() {
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAddress(@QueryParam("name") String name) {
        Response response = Response.status(Status.NOT_FOUND).entity("Object with key: "+name+" is not found.\n").build();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String json = "";
            while((json = br.readLine()) != null) {
                    User user = User.buildObjectFromJson(json);
                    if(user.getName().equals((name))) {
                        response = Response.ok(json).build();
                        log.info("Resource Found: "+json);
                        break;
                    }
                }
                br.close();
            } catch (IOException ex) {
                response = Response.status(Status.INTERNAL_SERVER_ERROR).
                        entity("Something went wrong with the server, exception trace: " + ex.getStackTrace()+"\n").build();
                log.error(ex.getStackTrace());
            }
        return response;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putAddress(final String json) {
        Response response = null;
        System.out.println(json);
        User user = null;
        try {
           user  = User.buildObjectFromJson(json);
           System.out.println(user);
           FileWriter fw = new FileWriter(FILENAME, true);
           fw.write(json+"\n");
           fw.close();
           log.info("Resource state changed.");
           response = Response.ok("State for resource with key: "+user.getName()+" changed.\n").build();
           log.info("Response generated for request json: "+json);
        } catch(IOException ex) {
            response = Response.status(Status.BAD_REQUEST).entity("Json not properly formatted.\n").build();
            log.error(ex.getStackTrace());
        }
        return response;
    }
    
}
