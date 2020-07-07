package com.example.rabbitmq.demo.service.impl;

import com.example.rabbitmq.demo.common.api.CommonResult;
import com.example.rabbitmq.demo.common.api.OrderParam;
import com.example.rabbitmq.demo.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderService.class);

    @Override
    public CommonResult generateOrder(OrderParam OrderParam) {
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {

    }
}
