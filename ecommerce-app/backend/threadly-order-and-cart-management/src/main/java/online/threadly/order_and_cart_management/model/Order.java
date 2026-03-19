package online.threadly.order_and_cart_management.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private UUID userId;

  private Double totalAmount;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  private LocalDateTime createdAt;

  @PrePersist
  public void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.orderStatus = OrderStatus.CREATED;
  }
}
