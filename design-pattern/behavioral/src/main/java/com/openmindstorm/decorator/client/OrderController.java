package com.openmindstorm.decorator.client;

import com.openmindstorm.decorator.dto.OrderDetail;
import com.openmindstorm.decorator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderControllerDecorator")
public class OrderController {

    @Autowired
    private OrderService orderServiceDecorator;

    @PostMapping("/ota/hotel/orders/cancel")
    public String cancelOrder(@RequestBody OrderDetail order) {

        boolean result = orderServiceDecorator.cancelOrder(order);
        if (result) {
            return "cancel order success";
        }
        return "cancel order failure ";
    }
}
