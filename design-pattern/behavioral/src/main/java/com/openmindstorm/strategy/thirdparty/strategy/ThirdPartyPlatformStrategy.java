package com.openmindstorm.strategy.thirdparty.strategy;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;

/**
 * 第三方平台策略类
 */
public interface ThirdPartyPlatformStrategy {

    boolean createOrder();

    boolean cancelOrder();

    boolean payOrder();

    OrderDetail queryOrder();
}
