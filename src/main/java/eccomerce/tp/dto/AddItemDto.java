package eccomerce.tp.dto;

import java.math.BigInteger;

public class AddItemDto {

    private Long productId;
    private BigInteger quantity;

    public AddItemDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddItemDto{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
