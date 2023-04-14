package edu.c322final.orderservice.controller;

import edu.c322final.orderservice.model.Order;
import edu.c322final.orderservice.model.Sandwich;
import edu.c322final.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }
    @PostMapping()
    public int create(@RequestBody Order order) {
        Order newOrder = repository.save(order);
        return newOrder.getId();
    }
}
