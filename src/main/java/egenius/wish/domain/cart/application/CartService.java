package egenius.wish.domain.cart.application;

import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.dtos.in.UpdateCheckedInDto;
import egenius.wish.domain.cart.dtos.out.GetCartOutDto;

public interface CartService {

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     * 2. 장바구니 조회
     * 3. 체크 선택/취소
     */

    // 1. 장바구니에 상품 추가
    void addProduct(AddProductInDto inDto, String userEmail);

    // 2. 장바구니 조회
    GetCartOutDto getCart(String userEmail);

    // 3. 체크 선택/취소
    void updateChecked(UpdateCheckedInDto inDto);

    // 4. 장바구니 상품 삭제
    void deleteProduct(Long productInCartId);

    // 5. 장바구니 상품 수량 변경
    void updateProductCount(Long productInCartId, Integer count);
}
