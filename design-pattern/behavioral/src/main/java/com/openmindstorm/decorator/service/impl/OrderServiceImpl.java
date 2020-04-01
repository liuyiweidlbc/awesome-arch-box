package com.openmindstorm.decorator.service.impl;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.decorator.service.OrderService;
import com.openmindstorm.decorator.thirdparty.context.ThirdPartyPlatformStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderServiceDecorator")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ThirdPartyPlatformStrategyContext thirdPartyPlatformCancelStrategyContext;

    @Override
    public boolean cancelOrder(OrderDetail order) {
        return thirdPartyPlatformCancelStrategyContext.cancelOrder(order);
    }
}
