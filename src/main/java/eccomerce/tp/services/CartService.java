package eccomerce.tp.services;

import eccomerce.tp.dto.AddItemDto;
import eccomerce.tp.entities.Cart;


public interface CartService {

    Cart saveCart(Cart cart);

    Cart getCartById(Long id);

    Cart addItem(Long cartId, AddItemDto itemDto);

    void deleteCartById(Long id);


}
