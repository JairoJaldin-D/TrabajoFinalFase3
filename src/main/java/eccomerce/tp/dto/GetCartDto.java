package eccomerce.tp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GetCartDto {
    private Long id;
    private LocalDateTime createdAt;
    private List<GetItemDto> items;
    private BigDecimal totalPrice;

    public GetCartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<GetItemDto> getItems() {
        return items;
    }

    public void setItems(List<GetItemDto> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "GetCartDto{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
