package edu.c322final.orderservice.controller;

import edu.c322final.orderservice.model.*;
import edu.c322final.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    public OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderRepository.getReferenceById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Order> getOrderbyCustomerId(@PathVariable int id) {
        return orderRepository.findOrderByCustomerId(id);
    }

    @PostMapping
    public int createOrder(@RequestBody Order order) {
        double total = 0;

        Sandwich sandwich = new ConcreteSandwich();
        for(int i = 0; i < order.getAvocadoCount();i++) {
            sandwich  = new AvocadoDecorator(sandwich);
        }
        for(int i = 0; i < order.getHamCount();i++) {
            sandwich  = new HamDecorator(sandwich);
        }
        for(int i = 0; i < order.getTurkeyCount();i++) {
            sandwich  = new TurkeyDecorator(sandwich);
        }
        total += sandwich.getPrice();

        List<SideModel> sideModels = order.getSides();
        List<Side> sideList = new ArrayList<>();
        for (int i = 0; i < sideModels.size(); i++) {
            sideModels.get(i).setOrder(order);
            Side side;
            if (sideModels.get(i).getType().equals("Drink")) {
                side = new Drink(sideModels.get(i).getName(),sideModels.get(i).getSize());
            } else {

                side = new Chips(sideModels.get(i).getName());
            }

            sideModels.get(i).setPrice(side.getPrice());
            sideList.add(side);


        }

        SideIterator sideIterator = new SideIterator(sideList);

        while (sideIterator.hasNext()) {
            total += sideIterator.next().getPrice();
        }


        order.setTotal(total);
        Order order1 = orderRepository.save(order);
        return order1.getId();
    }


    @PostMapping("/reorder/{id}")
    public int reorder(@PathVariable int id) {
        Order order = orderRepository.getReferenceById(id);


        Order newOrder = new Order();
        newOrder.setCustomerId(order.getCustomerId());
        newOrder.setTotal(order.getTotal());
        newOrder.setAvocadoCount(order.getAvocadoCount());
        newOrder.setHamCount(order.getHamCount());
        newOrder.setTurkeyCount(order.getTurkeyCount());
        List<SideModel> sides = order.getSides();
        List<SideModel> newSides = new ArrayList<>();
        for (int i = 0; i< sides.size(); i++) {
            SideModel newModel = new SideModel();
            newModel.setSize(sides.get(i).getSize());
            newModel.setOrder(newOrder);
            newModel.setName(sides.get(i).getName());
            newModel.setType(sides.get(i).getType());
            newModel.setPrice(sides.get(i).getPrice());
            newSides.add(newModel);
        }
        newOrder.setSides(newSides);


        newOrder = orderRepository.save(newOrder);

        return newOrder.getId();

    }











}
