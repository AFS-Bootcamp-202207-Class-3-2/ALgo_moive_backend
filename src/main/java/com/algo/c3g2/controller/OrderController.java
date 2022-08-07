package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderRequest;
import com.algo.c3g2.controller.mapper.OrderMapper;
import com.algo.c3g2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/get/{orderId}")
    public Response generateOrderResponseById(@PathVariable String orderId) {
        return orderService.generateOrderResponseById(orderId);
    }
    @GetMapping("/generateOrder")
    public Response generateOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.generateOrder(OrderMapper.toEntity(orderRequest));
    }
}
