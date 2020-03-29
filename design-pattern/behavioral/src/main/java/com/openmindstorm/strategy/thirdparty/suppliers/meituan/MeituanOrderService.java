package com.openmindstorm.strategy.thirdparty.suppliers.meituan;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;
import com.openmindstorm.strategy.thirdparty.annotation.SupplierPlatform;
import com.openmindstorm.strategy.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@SupplierPlatform("MEITUAN")
@Service
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
