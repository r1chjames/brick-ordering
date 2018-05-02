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

    static OrderHeader buildSecondOrder() {
        return OrderHeader.builder()
                .customerId(UUID.randomUUID())
                .orderLines(buildNewOrderLines())
                .build();
    }

    static OrderHeader buildThirdOrder() {
        return OrderHeader.builder()
                .customerId(UUID.randomUUID())
                .orderLines(buildNewOrderLines())
                .build();
    }

    static List<OrderHeader> buildMultipleOrders() {
        OrderHeader orderOne = buildNewOrder();
        OrderHeader orderTwo = buildSecondOrder();
        OrderHeader orderThree = buildThirdOrder();

        return Arrays.asList(orderOne, orderTwo, orderThree);
    }

    private static List<OrderLine> buildNewOrderLines() {
        OrderLine line1 = OrderLine.builder()
                .itemNumber(12345678)
                .quantity(17)
                .build();

        OrderLine line2 = OrderLine.builder()
                .itemNumber(12345678)
                .quantity(4)
                .build();

        return Arrays.asList(line1, line2);
    }

}
