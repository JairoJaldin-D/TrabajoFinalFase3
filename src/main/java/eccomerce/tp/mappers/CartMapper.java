package eccomerce.tp.mappers;

import eccomerce.tp.dto.GetCartDto;
import eccomerce.tp.dto.GetItemDto;
import eccomerce.tp.entities.Cart;
import eccomerce.tp.entities.Item;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapper {


    public GetCartDto mapperToDto(Cart cart){

        GetCartDto cartDto = new GetCartDto();
        cartDto.setId(cart.getId());
        cartDto.setCreatedAt(cart.getCreatedAt());

        List<GetItemDto> itemsDto = new ArrayList();

        BigDecimal total = BigDecimal.ZERO;

        for (Item oneItem : cart.getItems()) {
            itemsDto.add(new GetItemDto(oneItem.getId(),
                    oneItem.getProduct().getId(),
                    oneItem.getProduct().getName(),
                    oneItem.getProduct().getDescription(),
                    oneItem.getPrice(),
                    oneItem.getProduct().getImage(),
                    oneItem.getQuantity()));

            var quantity = new BigDecimal(oneItem.getQuantity());

            total = total.add(oneItem.getPrice().multiply(quantity));

        }

        cartDto.setTotalPrice(total);

        cartDto.setItems(itemsDto);

        return cartDto;
    }





}
