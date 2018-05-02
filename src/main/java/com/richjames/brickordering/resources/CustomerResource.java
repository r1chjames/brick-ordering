package com.richjames.brickordering.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.services.OrdersService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;


@Path("/orders")
public class CustomerResource {

    private OrdersService ordersService;

    @Inject
    public CustomerResource(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Timed
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createOrder(
            OrderHeader orderToCreate,
            @Context HttpHeaders headers) {

        return Response
                .accepted(ordersService.createOrder(orderToCreate))
                .build();
    }

    @Timed
    @GET
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{orderId}")
    public Response getOrderById(
            @PathParam("orderId") UUID orderId,
            @Context HttpHeaders headers) {

        return Response
                .ok(ordersService.getOrderById(orderId))
                .build();
    }

}
