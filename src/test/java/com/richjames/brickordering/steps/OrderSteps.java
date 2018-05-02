package com.richjames.brickordering.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.resources.ApplicationResources;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.UUID;

import static com.richjames.brickordering.steps.OrderBuilder.buildNewOrder;
import static com.richjames.brickordering.steps.UtilSteps.startService;
import static com.richjames.brickordering.steps.UtilSteps.stopService;
import static junit.framework.TestCase.assertNotNull;

public class OrderSteps {

    private Data data;

    public OrderSteps(Data data) {
        this.data = data;
    }

    @Given("^A customer wants to buy any number of bricks$")
    public void aCustomerWantsToBuyAnyNumberOfBricks() {
        OrderHeader orderToBeSumbitted = buildNewOrder();
        data.setOrderToBeSumitted(orderToBeSumbitted);
    }


    @When("^A \"([^\"]*)\" request for a number of bricks is submitted$")
    public void ARequestForANumberOfBricksIsSumbitted(String order) throws IOException {
        OrderHeader orderToBeSubmitted = data.getOrderToBeSumitted();

        ApplicationResources apiService = setUpRetrofit().create(ApplicationResources.class);

        Response<OrderHeader> returnedOrder = apiService.postNewOrder(orderToBeSubmitted).execute();
        data.setOrderHeaderResponse(returnedOrder.body());
    }


    @Then("^An Order reference is returned$")
    public void AnOrderReferenceIsReturned() {
        UUID orderRef = data.getOrderHeaderResponse().getOrderId();
        assertNotNull(orderRef);
    }


    private Retrofit setUpRetrofit() {
        String fullUri = String.format("http://localhost:%s%s/",
                "8080",
                "/order/v1");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return new Retrofit.Builder()
                .baseUrl(fullUri)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
    }


    @And("^The Order reference is unique to the submission$")
    public void theOrderReferenceIsUniqueToTheSubmission() throws Throwable {
        //TO BE IMPLEMENTED:
    }

    @Before
    public void startUp() throws Throwable {
        startService();
    }

    @After
    public void atEnd() throws Exception {
        stopService();
    }
}
