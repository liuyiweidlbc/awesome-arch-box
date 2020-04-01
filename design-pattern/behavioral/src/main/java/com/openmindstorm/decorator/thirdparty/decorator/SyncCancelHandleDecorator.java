package com.openmindstorm.decorator.thirdparty.decorator;

import com.openmindstorm.decorator.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.decorator.cancel.AbstractCancelDecorator;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncCancelHandleDecorator extends AbstractCancelDecorator {

    public SyncCancelHandleDecorator(ThirdPartyPlatformStrategy component) {
        super(component);
    }


    @Override
    public void decorateHandle() {
        log.info("SyncCancelHandleDecorator handling ...");
    }

    //合理拆分为4个策略后， 以下不必要的方法可以分别放到各自的装饰器里
    @Override
    public boolean createOrder() {
        return false;
    }

    @Override
    public boolean payOrder() {
        return false;
    }

    @Override
    public OrderDetail queryOrder() {
        return null;
    }
}
