package com.richjames.brickordering.resources;

import com.richjames.brickordering.entities.OrderHeader;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

public interface ApplicationResources {

    @Headers({"Accept: application/json"})
    @POST("/order/v1/orders")
    Call<OrderHeader> postNewOrder(@Body OrderHeader orderHeader);

    @Headers({"Accept: application/json"})
    @GET("/order/v1/orders/{orderId}")
    Call<OrderHeader> getOrderByRef(@Path("orderId") UUID orderId);

    @Headers({"Accept: application/json"})
    @GET("/order/v1/orders")
    Call<List<OrderHeader>> getAllOrders();
}