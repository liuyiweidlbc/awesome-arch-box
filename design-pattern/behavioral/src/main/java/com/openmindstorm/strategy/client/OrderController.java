package com.openmindstorm.strategy.client;

import com.openmindstorm.strategy.pojo.dto.OrderDetail;
import com.openmindstorm.strategy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/ota/hotel/order")
    public String echo(@RequestBody OrderDetail order) {

        boolean result = orderService.createOrder(order);
        if (result) {
            return "create order success";
        }
        return "create order failure ";
    }
}
