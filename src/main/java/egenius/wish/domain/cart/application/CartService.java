package egenius.wish.domain.cart.application;

import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.dtos.out.GetCartOutDto;

public interface CartService {

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     * 2. 장바구니 조회
     */

    // 1. 장바구니에 상품 추가
    void addProduct(AddProductInDto inDto, String userEmail);

    // 2. 장바구니 조회
    GetCartOutDto getCart(String userEmail);
}
