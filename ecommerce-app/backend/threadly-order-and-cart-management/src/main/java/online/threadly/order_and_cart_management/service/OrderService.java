package online.threadly.order_and_cart_management.service;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import online.threadly.order_and_cart_management.client.ProductClient;
import online.threadly.order_and_cart_management.dto.OrderResponse;
import online.threadly.order_and_cart_management.dto.Product;
import online.threadly.order_and_cart_management.exception.BadRequestException;
import online.threadly.order_and_cart_management.model.CartItem;
import online.threadly.order_and_cart_management.model.Order;
import online.threadly.order_and_cart_management.model.OrderItem;
import online.threadly.order_and_cart_management.model.OrderStatus;
import online.threadly.order_and_cart_management.repository.OrderItemRepository;
import online.threadly.order_and_cart_management.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

  private final CartItemService cartItemService;
  private final ProductClient productClient;
  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;

  public OrderResponse checkout(UUID userId, List<UUID> cartItemsIds) {
    List<CartItem> cartItems = cartItemService.getCartItemsByCartItemsIds(cartItemsIds);

    if (cartItems.isEmpty()) {
      throw new BadRequestException("Cart is empty");
    }

    List<UUID> productIds = cartItems.stream().map(CartItem::getProductId).toList();

    List<Product> products = productClient.getProductsByIds(productIds);

    Order order = new Order();
    order.setUserId(userId);
    Double totalAmount = 0.0;
    order = orderRepository.save(order);

    for (CartItem cartItem : cartItems) {
      Product product =
          products.stream()
              .filter(p -> p.getId().equals(cartItem.getProductId()))
              .findFirst()
              .orElseThrow();

      OrderItem orderItem = new OrderItem();

      orderItem.setOrderId(order.getId());
      orderItem.setProductId(product.getId());
      orderItem.setProductName(product.getName());
      orderItem.setImages(product.getImages());
      orderItem.setPrice(product.getPrice());
      orderItem.setQuantity(cartItem.getQuantity());

      totalAmount += product.getPrice() * cartItem.getQuantity();

      orderItemRepository.save(orderItem);
    }

    order.setTotalAmount(totalAmount);
    order.setOrderStatus(OrderStatus.PLACED);
    orderRepository.save(order);

    cartItemService.deleteAllCartItems(cartItems);

    return new OrderResponse(order.getId(), order.getTotalAmount(), order.getOrderStatus());
  }
}
