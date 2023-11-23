package egenius.wish.domain.wishproductlist.application;

import egenius.wish.domain.wishproductlist.dtos.out.GetWishProductOutDto;
import egenius.wish.domain.wishproductlist.dtos.out.IsWishOutDto;

public interface WishProductListService {
    /**
     * 1. 상품 찜하기
     * 2. 찜한 상품 조회하기
     * 3. 찜한 상품 삭제하기
     * 4. 해당 상품 찜 확인
     */

    // 1. 상품 찜하기
    void pickProduct(String userEmail, Long productId);

    // 2. 찜한 상품 조회하기
    GetWishProductOutDto getWishProductList(String userEmail);

    // 3. 찜한 상품 삭제하기
    void deleteWishProduct(Long wishProductId);

    // 4. 해당 상품 찜 확인
    IsWishOutDto isWish(String userEmail, Long productId);
}
