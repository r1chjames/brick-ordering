package com.richjames.brickordering.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderHeader {

    private UUID orderId;
    private UUID customerId;
    private List<OrderLine> orderLines;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public OrderHeader(UUID customerId, List<OrderLine> orderLines) {
        this.orderId = UUID.randomUUID();
        this.customerId = customerId;
        this.orderLines = orderLines;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }
}
