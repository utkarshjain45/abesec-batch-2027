package online.threadly.order_and_cart_management.repository;

import java.util.UUID;
import online.threadly.order_and_cart_management.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {}
