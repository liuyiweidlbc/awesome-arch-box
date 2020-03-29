package com.openmindstorm.strategy.thirdparty.context;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;
import com.openmindstorm.strategy.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.strategy.thirdparty.strategy.ThirdPartyPlatformStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ThirdPartyPlatformStrategyContext {

    private final Map<String, ThirdPartyPlatformStrategy> platformStrategyMap = new ConcurrentHashMap<>();

    @Autowired
    public ThirdPartyPlatformStrategyContext(Map<String, ThirdPartyPlatformStrategy> platformStrategyMapAutoWired) {
        platformStrategyMap.clear();

        platformStrategyMapAutoWired.forEach((k, v) -> {
            String key = v.getClass().getAnnotation(SupplierPlatform.class).value();
            this.platformStrategyMap.put(key, v);
        });

    }

    public boolean createOrder(OrderDetail order) {
        ThirdPartyPlatformStrategy platformStrategy = platformStrategyMap.get(order.getSupplierCode());
        if (platformStrategy == null) {
            throw new IllegalArgumentException("not found the target platform type, " + order.getSupplierCode());
        }
        return platformStrategy.createOrder();
    }
}
