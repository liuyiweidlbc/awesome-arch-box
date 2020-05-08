package com.openmindstorm.template.controller;

import com.openmindstorm.BehavioralApplication;
import com.openmindstorm.template.service.OrderService;
import com.openmindstorm.template.service.impl.DomesticOrderService;
import com.openmindstorm.template.service.impl.InternationalOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/template")
public class OrderController {

    @PostMapping(value = "/orders/{category}")
    public String createOrder(@PathVariable String category) {

        OrderService orderService = null;
        if (category.equals("0")) {
            orderService = BehavioralApplication.getBean(DomesticOrderService.class);
        } else {
            orderService = BehavioralApplication.getBean(InternationalOrderService.class);
        }
        orderService.createOrder();
        return "order created";
    }
}
