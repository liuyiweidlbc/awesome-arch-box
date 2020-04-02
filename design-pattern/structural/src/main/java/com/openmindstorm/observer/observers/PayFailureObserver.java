package com.openmindstorm.observer.observers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

@Slf4j
@Order(1)
@Component
public class PayFailureObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        log.info("pay failure handle , {}, {}", o , arg);
    }
}
