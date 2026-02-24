package online.threadly.order_and_cart_management.controller;

import lombok.RequiredArgsConstructor;
import online.threadly.order_and_cart_management.dto.AddToCartRequest;
import online.threadly.order_and_cart_management.dto.AddToCartResponse;
import online.threadly.order_and_cart_management.dto.CartResponse;
import online.threadly.order_and_cart_management.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<AddToCartResponse> addItemToCart(@RequestHeader("X-USER-ID") UUID userId, @RequestBody AddToCartRequest addToCartRequest) {
        System.out.println("UserId: " + userId + "\n" + "CartItemRequest: " + addToCartRequest.toString());
        return ResponseEntity.ok(cartService.addToCart(userId, addToCartRequest));
    }

    @GetMapping
    public ResponseEntity<CartResponse> getCart(@RequestHeader("X-USER-ID") UUID userId) {
        return ResponseEntity.ok(cartService.getCartForUser(userId));
    }

    @DeleteMapping("/item/{productId}")
    public ResponseEntity<AddToCartResponse> removeItemFromCart(@RequestHeader("X-USER-ID") UUID userId, @PathVariable UUID productId) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, productId));
    }

    @PutMapping("/item")
    public ResponseEntity<AddToCartResponse> updateCartItemQuantity(@RequestHeader("X-USER-ID") UUID userId, @RequestBody AddToCartRequest updateCartRequest) {
        return ResponseEntity.ok(cartService.updateCartItemQuantity(userId, updateCartRequest));
    }
}
