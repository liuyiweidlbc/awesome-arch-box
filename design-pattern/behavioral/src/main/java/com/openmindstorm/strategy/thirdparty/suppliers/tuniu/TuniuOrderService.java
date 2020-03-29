package com.openmindstorm.strategy.thirdparty.suppliers.tuniu;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;
import com.openmindstorm.strategy.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.strategy.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SupplierPlatform("TUNIU")
@Service
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
