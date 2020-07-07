package com.example.rabbitmq.demo.config;


import com.example.rabbitmq.demo.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    DirectExchange orderDirect(){
        return (DirectExchange) ExchangeBuilder.directExchange(
                QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    @Bean
    DirectExchange orderTTLDirect(){
        return (DirectExchange) ExchangeBuilder.directExchange(
                QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    @Bean
    public Queue orderQueue(){
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getQueue());
    }

    @Bean
    public Queue orderTTLQueue(){
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getQueue())
                .withArgument("x-dead-letter-exchange",QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .withArgument("x-dead-letter-exchange",QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())
                .build();
    }

    @Bean
    Binding orderBinding(DirectExchange orderDirect,Queue orderQueue){
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    @Bean
    Binding orderTTLBinding(DirectExchange orderTTLDirect,Queue orderTTLQueue){
        return BindingBuilder
                .bind(orderTTLQueue)
                .to(orderTTLDirect)
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }

}
