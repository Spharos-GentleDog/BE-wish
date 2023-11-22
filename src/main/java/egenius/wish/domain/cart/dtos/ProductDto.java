package egenius.wish.domain.cart.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ProductDto {
    private Long product_detail_id;
    private Integer count;
    private Boolean chekced;
}
