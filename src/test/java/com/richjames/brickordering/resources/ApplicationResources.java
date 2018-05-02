package com.richjames.brickordering.resources;

import com.richjames.brickordering.entities.OrderHeader;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApplicationResources {

    @Headers({"Accept: application/json"})
    @POST("/order/v1/orders")
    Call<OrderHeader> postNewOrder(@Body OrderHeader orderHeader);
}