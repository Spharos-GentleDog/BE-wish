package egenius.wish.domain.cart.presentation;

import egenius.wish.domain.cart.application.CartService;
import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.dtos.in.UpdateCheckedInDto;
import egenius.wish.domain.cart.dtos.out.GetCartOutDto;
import egenius.wish.domain.cart.webdto.in.AddProductWebInDto;
import egenius.wish.domain.cart.webdto.in.UpdateCheckedWebInDto;
import egenius.wish.domain.cart.webdto.out.GetCartWebOutDto;
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
     * 2. 장바구니 조회
     * 3. 체크 선택/취소
     */


    // 1. 장바구니에 상품 추가
    @PostMapping("")
    public BaseResponse<?> addProduct(@RequestBody AddProductWebInDto webInDto, @RequestHeader String userEmail) {
        AddProductInDto inDto = modelMapper.map(webInDto, AddProductInDto.class);
        cartService.addProduct(inDto, userEmail);
        return new BaseResponse<>();
    }

    // 2. 장바구니 조회
    @GetMapping("")
    public BaseResponse<?> getCart(@RequestHeader String userEmail) {
        GetCartOutDto outDto = cartService.getCart(userEmail);
        GetCartWebOutDto webOutDto = modelMapper.map(outDto, GetCartWebOutDto.class);
        return new BaseResponse<>(webOutDto);
    }

    // 3. 체크 선택/취소
    @PutMapping("/checked")
    public BaseResponse<?> updateChecked(@RequestBody UpdateCheckedWebInDto webInDto) {
        UpdateCheckedInDto inDto = modelMapper.map(webInDto, UpdateCheckedInDto.class);
        cartService.updateChecked(inDto);
        return new BaseResponse<>();
    }

}
