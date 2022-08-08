package com.algo.c3g2.controller.mapper;

import com.algo.c3g2.controller.dto.OrderRequest;
import com.algo.c3g2.entity.Order;
import org.springframework.beans.BeanUtils;

public class OrderMapper {
    public static Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        return order;
    }
}
