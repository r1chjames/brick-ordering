package com.richjames.brickordering.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
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
