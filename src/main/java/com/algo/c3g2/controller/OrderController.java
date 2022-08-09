package com.algo.c3g2.controller;

import com.algo.c3g2.common.AuthAccess;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @AuthAccess
    @GetMapping("/get/{orderId}")
    public Response generateOrderResponseById(@PathVariable String orderId) {
        return orderService.generateOrderResponseById(orderId);
    }

    @PostMapping("/generateOrder")
    @AuthAccess
    public Response generateOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        return orderService.generateOrder(orderCreateRequest);
    }
    @AuthAccess
    @GetMapping("/query/paystate/{id}")
    public Response cycleQueryOrderState(@PathVariable String id) {
        return orderService.cycleQueryOrderState(id);
    }
    @AuthAccess
    @GetMapping("/pay/{id}")
    public Response payToChangeOrderState(@PathVariable String id) {
        return orderService.payToChangeOrderState(id);
    }
    @AuthAccess
    @GetMapping("/qr-code/{orderId}")
    public void getQrCodeImage(HttpServletResponse response,
                               @PathVariable("orderId") String orderId) {
        orderService.createQrCode(orderId,response);
    }

    @AuthAccess
    @GetMapping("/test/{orderId}")
    public Response testToBackOrderState(@PathVariable("orderId") String orderId) {
       return orderService.testToBackOrderState(orderId);
    }

}
