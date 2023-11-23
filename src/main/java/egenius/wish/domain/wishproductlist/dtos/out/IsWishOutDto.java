package egenius.wish.domain.wishproductlist.dtos.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsWishOutDto {
    private Long wishProductId;
}
