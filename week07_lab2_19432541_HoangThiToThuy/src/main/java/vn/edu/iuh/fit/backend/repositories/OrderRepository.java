package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders u WHERE u.order_date > ?1 AND u.order_date < ?2",
            nativeQuery = true)
    public List<Order> findOrderByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
