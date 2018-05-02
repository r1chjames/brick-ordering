package com.richjames.brickordering.services;

import com.google.inject.Inject;
import com.richjames.brickordering.dao.OrderHeaderDao;
import com.richjames.brickordering.dao.OrderLineDao;
import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.entities.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class OrdersService {

    private OrderHeaderDao orderHeaderDao;
    private OrderLineDao orderLineDao;

    @Inject
    public OrdersService(OrderHeaderDao orderHeaderDao, OrderLineDao orderLineDao) {
        this.orderHeaderDao = orderHeaderDao;
        this.orderLineDao = orderLineDao;
    }

    public OrderHeader createOrder(OrderHeader orderToCreate) {
        OrderHeader orderHeaderCreated = orderHeaderDao.createOrder(orderToCreate);
        List<OrderLine> orderLinesCreated = new ArrayList<>();
        orderToCreate.getOrderLines().forEach(line -> {
            line.setOrderId(orderHeaderCreated.getOrderId());
            orderLinesCreated.add(orderLineDao.createOrderLine(line));
        });

        orderHeaderCreated.setOrderLines(orderLinesCreated);
        return orderHeaderCreated;
    }
}
