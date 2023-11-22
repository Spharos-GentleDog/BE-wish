package egenius.wish.domain.cart.application;

import egenius.wish.domain.cart.dtos.in.AddProductInDto;

public interface CartService {

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     */

    // 1. 장바구니에 상품 추가
    public void addProduct(AddProductInDto inDto, String userEmail);
}
