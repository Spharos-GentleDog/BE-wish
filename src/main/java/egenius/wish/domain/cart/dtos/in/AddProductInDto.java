package egenius.wish.domain.cart.dtos.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProductInDto {
    private Long productDetailId;

    private Integer count;

    private Boolean checked;

    private String brandName;

    private String userEmail;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
