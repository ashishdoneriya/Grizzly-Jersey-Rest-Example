package com.eenzee.example.rest.resource;


import com.eenzee.example.rest.model.ExampleBody;
import com.eenzee.example.rest.model.ReturnBody;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * An example resource - a webservice resource.
 * Defines the paths, and where variables come from - path, query or body
 *
 */
@Path("/basepath")
public class ExampleResource {
    private StringBuilder sb;

    /**
     * An example get method that takes a path parameter and optional query param
     * Query parameters default value is null
     * GET cannot have a body
     * @param pathParam
     * @param queryParam
     * @return Response with http status of ok (200) status and plain text
     */
    @GET
    @Path("/getlocation/{pathparam}")
    @Produces(MediaType.TEXT_PLAIN) //returns plain text
    public Response getResponse(@PathParam("pathparam") String pathParam, @QueryParam("queryparam") String queryParam){
        sb = new StringBuilder();
        sb.append("pathParam: ").append(pathParam);
        if(queryParam!=null) {
            sb.append(", ").append("queryParam: ").append(queryParam);
        }
        return Response.ok(sb.toString()).build();
    }

    /**
     * An example post method that takes a path parameter, a body and an optional query param
     * POST is usually used for creation of objects
     * @param pathParam
     * @param queryParam
     * @param body
     * @return Response with an http status of created (201) and an xml body
     */
    @POST
    @Path("/postlocation/{pathparam}")
    @Produces(MediaType.APPLICATION_XML) //produces xml
    @Consumes(MediaType.APPLICATION_JSON) //consumes json body
    public Response postResponse(@PathParam("pathparam") String pathParam, @QueryParam("queryparam") String queryParam, ExampleBody body){
        System.out.println("in post - body is: " + body.toString());
        ReturnBody returnBody = new ReturnBody(pathParam, body);
        if(queryParam!=null) {
            returnBody.setQueryParam(queryParam);
        }
        System.out.println("return body is: " + returnBody);
        Response response = Response.status(Status.CREATED).entity(returnBody).build();
        return response;
    }

    /**
     * An example put method that takes a path parameter, a body and an optional query param
     * PUT is usually used for the update of objects
     * @param pathParam
     * @param queryParam
     * @param body
     * @return Response with an http status of accepted (202) and an xml body
     */
    @PUT
    @Path("/putlocation/{pathparam}")
    @Produces(MediaType.APPLICATION_XML) //produces xml
    @Consumes(MediaType.APPLICATION_JSON) //consumes json body
    public Response putResponse(@PathParam("pathparam") String pathParam, @QueryParam("queryparam") String queryParam, ExampleBody body){
        ReturnBody returnBody = new ReturnBody(pathParam, body);
        if(queryParam!=null) {
            returnBody.setQueryParam(queryParam);
        }
        return Response.status(Status.ACCEPTED).entity(returnBody).build();
    }

    /**
     * An example delete method that takes a path parameter and optional query param
     * Query parameters default value is null
     * DELETE cannot have a body
     * @param pathParam
     * @param queryParam
     * @return Response with http status of ok (200) status and plain text
     */
    @DELETE
    @Path("/deletelocation/{pathparam}")
    @Produces(MediaType.TEXT_PLAIN) //returns plain text
    public Response deleteResponse(@PathParam("pathparam") String pathParam, @QueryParam("queryparam") String queryParam){
        sb = new StringBuilder();
        sb.append("pathParam: ").append(pathParam);
        if(queryParam!=null) {
            sb.append(", ").append("queryParam: ").append(queryParam);
        }
        return Response.status(Status.NOT_IMPLEMENTED).entity(sb.toString()).build();
    }

    @GET
    @Path("/failure")
    @Produces(MediaType.TEXT_PLAIN)
    public Response failureResponse(){
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity("This is a server failure!").build();
    }
}
