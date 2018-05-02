package com.richjames.brickordering.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLine {

    private int itemNumber;
    private int quantity;
}
