package egenius.wish.domain.cart.presentation;

import egenius.wish.domain.cart.application.CartService;
import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.dtos.in.UpdateCheckedInDto;
import egenius.wish.domain.cart.dtos.out.GetCartOutDto;
import egenius.wish.domain.cart.dtos.out.GetCheckedCartOutDto;
import egenius.wish.domain.cart.webdto.in.AddProductWebInDto;
import egenius.wish.domain.cart.webdto.in.UpdateCheckedWebInDto;
import egenius.wish.domain.cart.webdto.in.UpdateProductCountWebInDto;
import egenius.wish.domain.cart.webdto.out.GetCartWebOutDto;
import egenius.wish.domain.cart.webdto.out.GetCheckedCartWebOutDto;
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
     * 4. 장바구니 상품 삭제
     * 5. 장바구니 상품 수량 변경
     * 6. 장바구니 선택한 물품만 조회
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

    // 4. 장바구니 상품 삭제
    @DeleteMapping("/{productInCartId}")
    public BaseResponse<?> deleteProduct(@PathVariable Long productInCartId) {
        cartService.deleteProduct(productInCartId);
        return new BaseResponse<>();
    }

    // 5. 장바구니 상품 수량 변경
    @PutMapping("/{productInCartId}")
    public BaseResponse<?> updateProductCount(
            @PathVariable Long productInCartId,
            @RequestBody UpdateProductCountWebInDto webInDto) {
        cartService.updateProductCount(productInCartId, webInDto.getCount());
        return new BaseResponse<>();
    }

    // 6. 장바구니 선택한 물품만 조회
    @GetMapping("/checked")
    public BaseResponse<?> getCheckedProduct(@RequestHeader String userEmail) {
        GetCheckedCartOutDto outDto = cartService.getCheckedCart(userEmail);
        GetCheckedCartWebOutDto webOutDto = modelMapper.map(outDto, GetCheckedCartWebOutDto.class);
        return new BaseResponse<>(webOutDto);
    }

}
