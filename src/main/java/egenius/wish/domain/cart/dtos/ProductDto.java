package egenius.wish.domain.cart.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ProductDto {
    private Long productInCartId;
    private Long productDetailId;
    private Integer count;
    private Boolean checked;
}
