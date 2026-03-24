package online.threadly.order_and_cart_management.dto;

import java.util.List;
import lombok.Data;

@Data
public class CartResponse {
    List<CartItemDTO> cart;
    Double totalAmount;
}
