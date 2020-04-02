package com.openmindstorm.observer.service.impl;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.observer.observers.PayFailureObserver;
import com.openmindstorm.observer.observers.PaySuccessObserver;
import com.openmindstorm.observer.service.OrderServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Observable;

@Slf4j
@Service
public class OrderServiceImpl extends Observable implements OrderServcie, InitializingBean { //继承java.util.Observer实现观察者模式

    @Autowired
    private PayFailureObserver payFailureObserver;

    @Autowired
    private PaySuccessObserver paySuccessObserver;

    @Override
    public void afterPropertiesSet() throws Exception {
        addObserver(paySuccessObserver);
        addObserver(payFailureObserver);
    }

    @Override
    public boolean payOrder(OrderDetail order) {
        log.info("observer pay order ");

        //observable 通知所有观察者
        super.setChanged();
        super.notifyObservers("{ order } pay successful or failure with params");
        return true;
    }
}
