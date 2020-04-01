package com.openmindstorm.decorator.thirdparty.suppliers.ctrip;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.annotation.CancelHandle;
import com.openmindstorm.decorator.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.decorator.thirdparty.decorator.SyncCancelHandleDecorator;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SupplierPlatform("CTRIP")
@CancelHandle(SyncCancelHandleDecorator.class)
@Service("ctripOrderServiceDecorator")
public class CtripOrderService implements ThirdPartyPlatformStrategy {
    @Override
    public boolean createOrder() {
        log.info(" ctrip create order");
        return true;
    }

    @Override
    public boolean cancelOrder() {
        log.info(" ctrip cancel order");
        return true;
    }

    @Override
    public boolean payOrder() {
        log.info(" ctrip pay order");
        return true;
    }

    @Override
    public OrderDetail queryOrder() {
        log.info(" ctrip querr order");
        return new OrderDetail();
    }
}
