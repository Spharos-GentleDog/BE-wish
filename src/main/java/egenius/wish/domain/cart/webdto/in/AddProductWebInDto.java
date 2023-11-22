package egenius.wish.domain.cart.webdto.in;

import lombok.Getter;

@Getter
public class AddProductWebInDto {
    private Long productDetailId;

    private Integer count;

    private Boolean checked;

    private String brandName;
}
