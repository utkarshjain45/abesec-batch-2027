package online.threadly.order_and_cart_management.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemDTO {
  private UUID id;

  private UUID productId;

  private String name;

  private String slug;

  private String[] images;

  private Double price;

  private Integer quantity;
}
