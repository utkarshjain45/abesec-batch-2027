package online.threadly.order_and_cart_management.service;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import online.threadly.order_and_cart_management.model.CartItem;
import online.threadly.order_and_cart_management.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemService {

  private final CartItemRepository cartItemRepository;

  public List<CartItem> getCartItemsByCartItemsIds(List<UUID> cartItemIds) {
    return cartItemRepository.findAllById(cartItemIds);
  }

  public void deleteAllCartItems(List<CartItem> cartItems) {
    cartItemRepository.deleteAll(cartItems);
  }
}
