package com.openmindstorm.decorator.service;

import com.openmindstorm.decorator.dto.OrderDetail;

public interface OrderService {

    boolean cancelOrder(OrderDetail order);
}
