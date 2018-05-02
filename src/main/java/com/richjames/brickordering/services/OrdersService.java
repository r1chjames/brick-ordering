package com.richjames.brickordering.services;

import com.google.inject.Inject;
import com.richjames.brickordering.dao.OrderHeaderDao;
import com.richjames.brickordering.dao.OrderLineDao;
import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.entities.OrderLine;
import com.richjames.brickordering.exception.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public OrderHeader getOrderById(UUID orderId) {
        OrderHeader orderToReturn = orderHeaderDao.getOrderHeaderById(orderId);

        if (orderToReturn == null) {
            throw new ApplicationException("Order not found", 404);
        }

        List<OrderLine> orderLines = orderLineDao.getOrderLinesForId(orderId);
        orderToReturn.setOrderLines(orderLines);
        return orderToReturn;
    }

    public List<OrderHeader> getAllOrders() {
        List<OrderHeader> orderHeaders = orderHeaderDao.getAllOrderHeaders();
        orderHeaders.forEach(orderHeader -> {
            orderHeader.setOrderLines(orderLineDao.getOrderLinesForId(orderHeader.getOrderId()));
        });


        return orderHeaders;
    }
}
