package com.openmindstorm.observer.controller;

import com.openmindstorm.decorator.pojo.dto.OrderDetail;
import com.openmindstorm.observer.service.OrderServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("observer")
public class OrderController {

    @Autowired
    private OrderServcie orderServcie;

    @PostMapping("/ota/hotel/orders/pay")
    public String payOrder(OrderDetail order){

        boolean result = orderServcie.payOrder(order);
        if (result) {
            return "cancel order success";
        }
        return "cancel order failure ";
    }
}
