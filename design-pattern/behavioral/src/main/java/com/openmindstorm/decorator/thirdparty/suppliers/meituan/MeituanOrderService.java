package com.openmindstorm.decorator.thirdparty.suppliers.meituan;

import com.openmindstorm.decorator.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.annotation.CancelHandle;
import com.openmindstorm.decorator.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.decorator.thirdparty.decorator.SyncCancelHandleDecorator;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SupplierPlatform("MEITUAN")
@CancelHandle(SyncCancelHandleDecorator.class)
@Service("meituanOrderServiceDecorator")
public class MeituanOrderService implements ThirdPartyPlatformStrategy {
    @Override
    public boolean createOrder() {
        log.info(" meituan create order");
        return true;
    }

    @Override
    public boolean cancelOrder() {
        log.info(" meituan cancel order");
        return true;
    }

    @Override
    public boolean payOrder() {
        log.info(" meituan pay order");
        return true;
    }

    @Override
    public OrderDetail queryOrder() {
        log.info(" meituan querr order");
        return new OrderDetail();
    }
}
