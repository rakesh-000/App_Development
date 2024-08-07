package com.example.demo.service;

import com.example.demo.model.OrderModel;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel saveOrder(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public OrderModel updateOrder(Long id, OrderModel orderModel) {
        Optional<OrderModel> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            OrderModel existingOrder = existingOrderOpt.get();
            existingOrder.setTransportMode(orderModel.getTransportMode());
            existingOrder.setQuantity(orderModel.getQuantity());
            existingOrder.setRawMaterialName(orderModel.getRawMaterialName());
            existingOrder.setDescription(orderModel.getDescription());
            existingOrder.setAddress(orderModel.getAddress());
            existingOrder.setPhoneNumber(orderModel.getPhoneNumber());
            existingOrder.setCustomerName(orderModel.getCustomerName());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}