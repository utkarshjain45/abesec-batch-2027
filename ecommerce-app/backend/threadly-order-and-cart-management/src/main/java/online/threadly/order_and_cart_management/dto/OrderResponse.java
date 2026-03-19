package online.threadly.order_and_cart_management.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import online.threadly.order_and_cart_management.model.OrderStatus;

@Data
@AllArgsConstructor
public class OrderResponse {
  private UUID orderId;
  private Double amount;
  private OrderStatus orderStatus;
}
