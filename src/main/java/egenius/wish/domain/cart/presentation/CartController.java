package egenius.wish.domain.cart.presentation;

import egenius.wish.domain.cart.application.CartService;
import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.webdto.in.AddProductWebInDto;
import egenius.wish.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wish/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ModelMapper modelMapper;

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     */


    // 1. 장바구니에 상품 추가
    @PostMapping("")
    public BaseResponse<?> addProduct(@RequestBody AddProductWebInDto webInDto, @RequestHeader String userEmail) {
        AddProductInDto inDto = modelMapper.map(webInDto, AddProductInDto.class);
        cartService.addProduct(inDto, userEmail);
        return new BaseResponse<>();
    }



}
