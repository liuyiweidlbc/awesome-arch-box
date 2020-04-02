package com.openmindstorm.observer.service;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;

public interface OrderServcie {

    boolean payOrder(OrderDetail order);
}
