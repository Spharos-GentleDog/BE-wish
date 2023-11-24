package egenius.wish.domain.wishproductlist.presentation;

import egenius.wish.domain.wishproductlist.application.WishProductListService;
import egenius.wish.domain.wishproductlist.dtos.out.GetWishProductOutDto;
import egenius.wish.domain.wishproductlist.dtos.out.IsWishOutDto;
import egenius.wish.domain.wishproductlist.webdto.in.PickProductWebInDto;
import egenius.wish.domain.wishproductlist.webdto.out.GetWishProductWetOutDto;
import egenius.wish.domain.wishproductlist.webdto.out.IsWishWebOutDto;
import egenius.wish.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wish/wishproductlist")
@RequiredArgsConstructor
public class WishProductListController {

    private final WishProductListService wishProductListService;
    private final ModelMapper modelMapper;

    /**
     * 1. 상품 찜하기
     * 2. 찜한 상품 조회하기
     * 3. 찜한 상품 삭제하기
     * 4. 해당 상품 찜 확인
     */

    // 1. 상품 찜하기
    @PostMapping("")
    public BaseResponse<?> pickProduct(@RequestHeader String userEmail, @RequestBody PickProductWebInDto webInDto) {
        wishProductListService.pickProduct(userEmail, webInDto.getProductId());
        return new BaseResponse<>();
    }

    // 2. 찜한 상품 조회하기
    @GetMapping("/all")
    public BaseResponse<?> getWishProductList(@RequestHeader String userEmail) {
        GetWishProductOutDto outDto = wishProductListService.getWishProductList(userEmail);
        GetWishProductWetOutDto wetOutDto = modelMapper.map(outDto, GetWishProductWetOutDto.class);
        return new BaseResponse<>(wetOutDto);
    }

    // 3. 찜한 상품 삭제하기
    @DeleteMapping("/{wishProductId}")
    public BaseResponse<?> deleteProduct(@PathVariable Long wishProductId) {
        wishProductListService.deleteWishProduct(wishProductId);
        return new BaseResponse<>();
    }

    // 4. 해당 상품 찜 확인
    @GetMapping("/{productId}")
    public BaseResponse<?> isWish(@RequestHeader String userEmail, @PathVariable Long productId) {
        IsWishOutDto outDto = wishProductListService.isWish(userEmail, productId);
        IsWishWebOutDto webOutDto = modelMapper.map(outDto, IsWishWebOutDto.class);
        return new BaseResponse<>(webOutDto);
    }

}
