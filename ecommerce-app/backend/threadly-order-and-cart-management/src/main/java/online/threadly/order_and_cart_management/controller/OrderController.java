package online.threadly.order_and_cart_management.controller;

import java.util.List;
import java.util.UUID;
import online.threadly.order_and_cart_management.dto.OrderResponse;
import online.threadly.order_and_cart_management.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

  private OrderService orderService;

  @PostMapping("/checkout")
  public ResponseEntity<OrderResponse> checkout(
      @RequestHeader("X-USER-ID") UUID userID, @RequestBody List<UUID> cartItemIds) {
    return ResponseEntity.ok(orderService.checkout(userID, cartItemIds));
  }
}
