package eccomerce.tp.controllers;

import eccomerce.tp.dto.AddItemDto;
import eccomerce.tp.dto.GetCartDto;
import eccomerce.tp.entities.Cart;
import eccomerce.tp.mappers.CartMapper;
import eccomerce.tp.services.CartService;
import eccomerce.tp.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class CartController {
    Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartMapper cartMapper;

    @PostMapping("/carts")
    public Cart newCart(){
        Cart cart = new Cart();
        cart.setCreatedAt(LocalDateTime.now());
        return cartService.saveCart(cart);
    }

    @GetMapping("/carts/{cartId}")
    public GetCartDto getCartById(@PathVariable(name = "cartId") Long cartId) {
        Cart currentCart = cartService.getCartById(cartId);
        // transformamos entidad a dto
     return cartMapper.mapperToDto(currentCart);
    }

    @PutMapping("/carts/{cartId}/items")
    public GetCartDto addItemCart(@PathVariable(name = "cartId") Long cartId , @RequestBody AddItemDto item ){

        logger.info("item a agregar " + item);

        Cart saved = cartService.addItem(cartId,item);

        return cartMapper.mapperToDto(saved);
    }
    @DeleteMapping("/carts/{cartId}")
    public GetCartDto deleteCartById(@PathVariable(name = "cartId") Long cartId) {
        Cart currentCart = cartService.getCartById(cartId);
        cartService.deleteCartById(currentCart.getId());
        // transformamos entidad a dto
        return cartMapper.mapperToDto(currentCart);
    }


}
