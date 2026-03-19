package online.threadly.order_and_cart_management.repository;

import java.util.UUID;
import online.threadly.order_and_cart_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
