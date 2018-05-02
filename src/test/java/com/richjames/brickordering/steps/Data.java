package com.richjames.brickordering.steps;


import com.richjames.brickordering.entities.OrderHeader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private OrderHeader orderHeaderResponse;
    private OrderHeader orderToBeSumitted;
}
