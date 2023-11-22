package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.backend.services.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findOrderByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findOrderByOrderDateBetween(startDate, endDate);
    }


}
