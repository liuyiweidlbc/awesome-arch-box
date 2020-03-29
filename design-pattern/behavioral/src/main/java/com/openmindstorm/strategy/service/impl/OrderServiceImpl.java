package com.openmindstorm.strategy.service.impl;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;
import com.openmindstorm.strategy.service.OrderService;
import com.openmindstorm.strategy.thirdparty.context.ThirdPartyPlatformStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ThirdPartyPlatformStrategyContext platformStrategyContext;

    @Override
    public boolean createOrder(OrderDetail order) {
        return platformStrategyContext.createOrder(order);
    }
}
