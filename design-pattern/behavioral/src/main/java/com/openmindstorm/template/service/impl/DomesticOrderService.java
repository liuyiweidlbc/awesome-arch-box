package com.openmindstorm.template.service.impl;

import com.openmindstorm.template.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DomesticOrderService extends OrderService {
    @Override
    protected void checkOrder() {

    }

    @Override
    protected void processCreate() {
      log.info("国内订单处理流程");
    }

    @Override
    protected void asyncNotify() {

    }
}
