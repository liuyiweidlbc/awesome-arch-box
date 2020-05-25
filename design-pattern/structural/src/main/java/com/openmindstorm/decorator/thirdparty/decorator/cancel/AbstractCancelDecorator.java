package com.openmindstorm.decorator.thirdparty.decorator.cancel;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;

public abstract class AbstractCancelDecorator implements ThirdPartyPlatformStrategy {

    /**
     * 被装饰者接口
     */
    private ThirdPartyPlatformStrategy component;

    public AbstractCancelDecorator(ThirdPartyPlatformStrategy component) {
        this.component = component;
    }

    @Override
    public boolean cancelOrder() {
        decorateHandle();
        return component.cancelOrder();
    }

    /**
     * 装饰抽象方法
     */
    public abstract void decorateHandle();


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
