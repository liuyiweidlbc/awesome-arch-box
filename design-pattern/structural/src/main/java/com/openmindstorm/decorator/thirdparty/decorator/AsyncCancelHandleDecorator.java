package com.openmindstorm.decorator.thirdparty.decorator;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.decorator.thirdparty.decorator.cancel.AbstractCancelDecorator;
import com.openmindstorm.decorator.thirdparty.strategy.ThirdPartyPlatformStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncCancelHandleDecorator extends AbstractCancelDecorator {//context里的Strategy应该细分

    /**
     * 构建函数传递被装饰者
     * @param component
     */
    public AsyncCancelHandleDecorator(ThirdPartyPlatformStrategy component) {
        super(component);
    }


    @Override
    public void decorateHandle() {
        log.info("AsyncCancelHandleDecorator handling ...");
    }

}
