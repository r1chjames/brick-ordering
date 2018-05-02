package com.richjames.brickordering.steps;


import com.richjames.brickordering.entities.OrderHeader;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {

    private OrderHeader orderHeaderResponse;
    private List<OrderHeader> orderHeaderResponseList;
    private OrderHeader orderToBeSumitted;
    private int responseCode;
}
