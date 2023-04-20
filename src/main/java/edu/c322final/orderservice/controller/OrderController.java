package edu.c322final.orderservice.controller;

import edu.c322final.orderservice.model.Order;
import edu.c322final.orderservice.model.Sandwich;
import edu.c322final.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable int id) {
        return repository.findById(id).get();
    }
    @PostMapping
    public int create(@RequestBody Order order) {
        Order newOrder = repository.save(order);
        return newOrder.getId();
    }
    @GetMapping("/{id}")
    public int reorder(@PathVariable int id) {
        Order order = findById(id);
        return create(order);
    }
}
