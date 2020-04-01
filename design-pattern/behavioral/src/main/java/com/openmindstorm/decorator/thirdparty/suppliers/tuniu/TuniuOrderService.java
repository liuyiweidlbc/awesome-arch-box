package com.openmindstorm.decorator.thirdparty.suppliers.tuniu;

import com.openmindstorm.decorator.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.annotation.CancelHandle;
import com.openmindstorm.decorator.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.decorator.thirdparty.decorator.AsyncCancelHandleDecorator;
import com.openmindstorm.decorator.thirdparty.decorator.SyncCancelHandleDecorator;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SupplierPlatform("TUNIU")
@CancelHandle(AsyncCancelHandleDecorator.class)
@Service("tuniuOrderServiceDecorator")
public class TuniuOrderService implements ThirdPartyPlatformStrategy {
    @Override
    public boolean createOrder() {
        log.info(" tuniu create order");
        return true;
    }

    @Override
    public boolean cancelOrder() {
        log.info(" tuniu cancel order");
        return true;
    }

    @Override
    public boolean payOrder() {
        log.info(" tuniu pay order");
        return true;
    }

    @Override
    public OrderDetail queryOrder() {
        log.info(" tuniu querr order");
        return new OrderDetail();
    }
}
