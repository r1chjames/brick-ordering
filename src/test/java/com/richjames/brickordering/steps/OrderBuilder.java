package com.richjames.brickordering.steps;

import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.entities.OrderLine;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {

    static OrderHeader buildNewOrder() {
        return OrderHeader.builder()
                .customerId(UUID.randomUUID())
                .orderLines(buildNewOrderLines())
                .build();
    }

    private static List<OrderLine> buildNewOrderLines() {
        OrderLine line1 = OrderLine.builder()
                .itemNumber(12345678)
                .quantity(17)
                .build();

        OrderLine line2 = OrderLine.builder()
                .itemNumber(12345678)
                .quantity(17)
                .build();

        return Arrays.asList(line1, line2);
    }

}
