package egenius.wish.domain.wishproductlist.webdto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsWishWebOutDto {
    private Long wishProductId;
}
