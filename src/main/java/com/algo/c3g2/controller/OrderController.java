package com.algo.c3g2.controller;

import com.algo.c3g2.common.AuthAccess;
import com.algo.c3g2.common.Response;
import com.algo.c3g2.controller.dto.OrderCreateRequest;
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
    @GetMapping("/qr-code/finish/{orderId}")
    public void getUpdateFinishQrCodeImage(HttpServletResponse response,
                                           @PathVariable("orderId") String orderId) {
        orderService.updateFinishQrCodeImage(orderId,response);
    }

    /**
     * 二维码回调函数
     * 更新订单状态为 2
     * @param orderId
     */
    @AuthAccess
    @GetMapping("/update/finish/{orderId}")
    public Response updateOrderFinish(@PathVariable("orderId") String orderId) {
        return orderService.updateOrderFinish(orderId);
    }

    @AuthAccess
    @GetMapping("/test/{orderId}")
    public Response testToBackOrderState(@PathVariable("orderId") String orderId) {
       return orderService.testToBackOrderState(orderId);
    }

    @AuthAccess
    @GetMapping("/user/{id}")
    public Response findOrdersByUserId(@PathVariable("id") String userId,
                                       @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                       @RequestParam(value = "pageSize",defaultValue = "3",required = false) int pageSize) {
        return orderService.findByUserId(userId,page,pageSize);
    }

    @DeleteMapping("/user/d/{orderId}")
    public Response deleteOrdersFromUserById(@PathVariable("orderId") String orderId) {
        return orderService.deleteOrdersFromUserById(orderId);
    }


}
