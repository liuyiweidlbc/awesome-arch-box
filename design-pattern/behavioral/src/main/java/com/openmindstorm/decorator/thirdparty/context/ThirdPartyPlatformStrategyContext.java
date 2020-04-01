package com.openmindstorm.decorator.thirdparty.context;

import com.openmindstorm.decorator.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.annotation.CancelHandle;
import com.openmindstorm.decorator.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component("thirdPartyPlatformCancelStrategyContext")
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


    public boolean cancelOrder(OrderDetail order) {
        ThirdPartyPlatformStrategy platformStrategy = platformStrategyMap.get(order.getSupplierCode());
        if (platformStrategy == null) {
            throw new IllegalArgumentException("not found the target platform type, " + order.getSupplierCode());
        }

        //引入装饰器
        Class annoValue = platformStrategy.getClass().getAnnotation(CancelHandle.class).value();
        Constructor declaredConstructor = null;
        try {
            declaredConstructor = annoValue.getConstructor(ThirdPartyPlatformStrategy.class);
            declaredConstructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException", e);
            e.printStackTrace();
        }

        boolean flag = false;
        try {
            flag = ((ThirdPartyPlatformStrategy) declaredConstructor.newInstance(platformStrategy)).cancelOrder();
        } catch (InstantiationException e) {
            log.error("InstantiationException", e);
        } catch (IllegalAccessException e) {
            log.error("IllegalAccessException", e);
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException", e);
        } catch (Exception e) {
            log.error("cancel order error: ", e);
        }
        return flag;
    }
}
