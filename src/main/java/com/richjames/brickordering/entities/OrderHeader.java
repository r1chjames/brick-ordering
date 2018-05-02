package com.richjames.brickordering.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderHeader {

    private UUID orderId;
    private UUID customerId;
    private List<OrderLine> orderLines;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @JsonCreator
    public OrderHeader(@JsonProperty("customerId") UUID customerId, @JsonProperty("orderLines") List<OrderLine> orderLines) {
        this.orderId = UUID.randomUUID();
        this.customerId = customerId;
        this.orderLines = orderLines;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }
}
