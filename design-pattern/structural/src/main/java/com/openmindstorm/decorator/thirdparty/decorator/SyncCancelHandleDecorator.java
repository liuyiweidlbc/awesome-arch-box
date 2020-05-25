package com.openmindstorm.decorator.thirdparty.decorator;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
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
}
