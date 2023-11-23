package egenius.wish.domain.wishproductlist.webdto.out;

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
public class GetWishProductWetOutDto {
    List<WishProductList> wishList;
}
