package com.openmindstorm.strategy.service;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;

public interface OrderService {

    boolean createOrder(OrderDetail order);
}
