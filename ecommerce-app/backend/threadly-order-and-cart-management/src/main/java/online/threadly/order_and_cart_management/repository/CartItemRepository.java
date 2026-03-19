package online.threadly.order_and_cart_management.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import online.threadly.order_and_cart_management.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
  Optional<CartItem> findByCartIdAndProductId(UUID cartId, UUID productId);

  List<CartItem> findAllByCartId(UUID cartId);

  // SELECT * FROM cart_items WHERE cart_id IN [cartId1, cartId2....];
  List<CartItem> findAllByCartItemIds(List<UUID> cartItemIds);
}
