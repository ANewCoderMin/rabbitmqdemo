package com.example.rabbitmq.demo.service.impl;

import com.example.rabbitmq.demo.common.api.CommonResult;
import com.example.rabbitmq.demo.common.api.OrderParam;
import com.example.rabbitmq.demo.component.CancelOrderSender;
import com.example.rabbitmq.demo.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderService.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam OrderParam) {

        LOGGER.info("process generateOrder");
        sendDelayMessage(11L);
        return CommonResult.success("下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("order cancel",orderId);
    }

    private void sendDelayMessage(long orderId) {
        long delayTimes = 6 * 1000;
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }
}
