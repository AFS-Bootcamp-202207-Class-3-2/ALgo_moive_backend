package com.algo.c3g2.controller;

import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderRequest;
import com.algo.c3g2.controller.mapper.OrderMapper;
import com.algo.c3g2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    @GetMapping("/query/paystate/{id}")
    public Response cycleQueryOrderState(@PathVariable String id) {
        return orderService.cycleQueryOrderState(id);
    }
    @GetMapping("/pay/{id}")
    public Response payToChangeOrderState(@PathVariable String id) {
        return orderService.payToChangeOrderState(id);
    }
    @GetMapping("/qr-code/{orderId}")
    public void getQrCodeImage(HttpServletResponse response,
                               @PathVariable("orderId") String orderId) {
        orderService.createQrCode(orderId,response);
    }



    @GetMapping("/test/{orderId}")
    public Response testToBackOrderState(@PathVariable("orderId") String orderId) {
       return orderService.testToBackOrderState(orderId);
    }

}
