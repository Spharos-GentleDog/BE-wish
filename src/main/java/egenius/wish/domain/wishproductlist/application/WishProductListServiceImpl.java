package egenius.wish.domain.wishproductlist.application;

import egenius.wish.domain.wishproductlist.dtos.out.GetWishProductOutDto;
import egenius.wish.domain.wishproductlist.dtos.out.IsWishOutDto;
import egenius.wish.domain.wishproductlist.entity.WishProductList;
import egenius.wish.domain.wishproductlist.infrastructure.WishProductListRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class WishProductListServiceImpl implements WishProductListService{
    private final WishProductListRepository wishProductListRepository;
    private final ModelMapper modelMapper;

    /**
     * 1. 상품 찜하기
     * 2. 찜한 상품 조회하기
     * 3. 찜한 상품 삭제하기
     * 4. 해당 상품 찜 확인
     */

    // 1. 상품 찜하기
    @Override
    public void pickProduct(String userEmail, Long productId) {
        // 상품 생성
        WishProductList product = WishProductList.builder()
                .userEmail(userEmail)
                .productId(productId)
                .build();
        // 저장
        wishProductListRepository.save(product);
    }

    // 2. 찜한 상품 조회하기
    @Override
    public GetWishProductOutDto getWishProductList(String userEmail) {
        // 상품 전체 조회
        List<WishProductList> list = wishProductListRepository.findAllByUserEmail(userEmail);
        return new GetWishProductOutDto(list);
    }

    // 3. 찜한 상품 삭제하기
    @Override
    public void deleteWishProduct(Long wishProductId) {
        // 상품 삭제
        wishProductListRepository.deleteByWishProductListId(wishProductId);
    }

    // 4. 해당 상품 찜 확인
    @Override
    public IsWishOutDto isWish(String userEmail, Long productId) {
        Optional<WishProductList> product = wishProductListRepository.findByUserEmailAndProductId(userEmail, productId);
        Long wishProductId = null;
        // product가 존재한다면, wishProductId를 반환한다
        if (product.isPresent() == true) {
            wishProductId = product.get().getWishProductListId();
        }
        return new IsWishOutDto(wishProductId);
    }
}
