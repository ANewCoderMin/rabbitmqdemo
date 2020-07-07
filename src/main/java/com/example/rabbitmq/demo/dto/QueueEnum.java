package com.example.rabbitmq.demo.dto;

import lombok.Getter;

@Getter
public enum QueueEnum {

    QUEUE_ORDER_CANCEL("mall.order.direct","mall.order.cancel","mall.order.cancel"),
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl","mall.order.cancel.ttl","mall.order.cancel.ttl");

    /*
    交换机名称
     */
    private String exchange;
    /*
    队列名称
     */
    private String queue;
    /*
    路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String queue, String routeKey) {
        this.exchange = exchange;
        this.queue = queue;
        this.routeKey = routeKey;
    }
}
