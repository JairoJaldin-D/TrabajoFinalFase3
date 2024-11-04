package eccomerce.tp.services.impl;

import eccomerce.tp.dto.AddItemDto;
import eccomerce.tp.entities.Cart;
import eccomerce.tp.entities.Item;
import eccomerce.tp.entities.Product;
import eccomerce.tp.exceptions.CartNotFoundException;
import eccomerce.tp.repositories.CartRepository;
import eccomerce.tp.services.CartService;
import eccomerce.tp.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;



    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new CartNotFoundException("No encontro el carrito"));

    }

    @Override
    public Cart addItem(Long cartId, AddItemDto itemDto) {
        //Buscamos el carrito por id
        Cart currentCart = this.getCartById(cartId);

        // buscamos el producto por id
        Product product = productService.getProductById(itemDto.getProductId());

        //armamos item
        Item newItem = new Item();
        newItem.setProduct(product);
        newItem.setQuantity(itemDto.getQuantity());
        newItem.setPrice(product.getPrice());
        newItem.setCart(currentCart);

        // guardamos la lista de item en el carrito
        List<Item> currentsItems = currentCart.getItems();
        currentsItems.add(newItem);
        currentCart.setItems(currentsItems);

        // guardamos carrito modificado
        logger.info("carrito a guardar " + currentCart);

        return this.saveCart(currentCart);
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }


}
