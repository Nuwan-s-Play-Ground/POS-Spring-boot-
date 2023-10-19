package lk.ijse.database.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.database.entity.Order;

@Service
public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}
