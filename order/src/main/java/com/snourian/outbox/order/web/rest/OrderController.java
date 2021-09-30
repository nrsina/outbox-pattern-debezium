package com.snourian.outbox.order.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.snourian.outbox.order.domain.Order;
import com.snourian.outbox.order.service.OrderService;
import com.snourian.outbox.order.web.dto.OrderCreatedDto;
import com.snourian.outbox.order.web.dto.OrderCreationDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;

@Controller("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Post
    public HttpResponse<OrderCreatedDto> createOrder(@Body @Valid OrderCreationDto dto) throws JsonProcessingException {
        Order newOrder = orderService.createOrder(dto.toOrder());
        return HttpResponse.ok(OrderCreatedDto.FromOrder(newOrder));
    }
}
