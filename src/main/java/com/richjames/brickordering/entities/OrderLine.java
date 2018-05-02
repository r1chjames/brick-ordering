package com.richjames.brickordering.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLine {

    private UUID id;
    private UUID orderId;
    private int itemNumber;
    private int quantity;
}
