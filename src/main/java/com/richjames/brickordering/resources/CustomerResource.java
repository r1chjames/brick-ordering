package com.richjames.brickordering.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {


    @Timed
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/example/")
    public Response getData(@Context HttpHeaders headers) {

        return Response
                .ok()
                .build();
    }

}
