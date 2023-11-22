package egenius.wish.domain.cart.application;

import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.entity.Cart;
import egenius.wish.domain.cart.infrastructure.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     */

    // 1. 장바구니에 상품 추가
    @Override
    public void addProduct(AddProductInDto inDto, String userEmail) {
        inDto.setUserEmail(userEmail);
        Cart cart = modelMapper.map(inDto, Cart.class);
        cartRepository.save(cart);
    }


}
