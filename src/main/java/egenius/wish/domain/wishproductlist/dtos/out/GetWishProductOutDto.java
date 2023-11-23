package egenius.wish.domain.wishproductlist.dtos.out;

import egenius.wish.domain.wishproductlist.entity.WishProductList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetWishProductOutDto {
    List<WishProductList> wishList;
}
