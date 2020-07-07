package com.example.rabbitmq.demo.service;

import com.example.rabbitmq.demo.common.api.CommonResult;
import com.example.rabbitmq.demo.common.api.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {

    @Transactional
    CommonResult generateOrder(OrderParam OrderParam);

    @Transactional
    void cancelOrder(Long orderId);
}
