package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    public List<Order> getAllOrder();

    public Order saveOrder(Order orders);

    public Optional<Order> findOrderById(Long id);

    public void deleteOrder(Long id);

    public List<Order> findOrderByDate(LocalDateTime startDate, LocalDateTime endDate);
}
