package egenius.wish.domain.wishproductlist.application;

import egenius.wish.domain.wishproductlist.dtos.out.GetWishProductOutDto;
import egenius.wish.domain.wishproductlist.entity.WishProductList;
import egenius.wish.domain.wishproductlist.infrastructure.WishProductListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WishProductListServiceImpl implements WishProductListService{
    private final WishProductListRepository wishProductListRepository;
    private final ModelMapper modelMapper;

    /**
     * 1. 상품 찜하기/찜취소하기
     * 2. 찜한 상품 조회하기
     * 3. 해당 상품 찜 확인
     */

    // 1. 상품 찜하기/찜취소하기
    @Override
    public Boolean pickProduct(String userEmail, Long productId) {
        // 조회
        Optional<WishProductList> result = wishProductListRepository.findByUserEmailAndProductId(userEmail, productId);
        // 존재한다면 삭제
        if (result.isPresent() == true) {
            wishProductListRepository.delete(result.get());
            return false;
        }
        // 없다면 생성
        else {
            WishProductList product = WishProductList.builder()
                    .userEmail(userEmail)
                    .productId(productId)
                    .build();
            wishProductListRepository.save(product);
            return true;
        }
    }

    // 2. 찜한 상품 조회하기
    @Override
    public GetWishProductOutDto getWishProductList(String userEmail) {
        // 상품 전체 조회
        List<WishProductList> list = wishProductListRepository.findAllByUserEmail(userEmail);
        return new GetWishProductOutDto(list);
    }

    // 3. 해당 상품 찜 확인
    @Override
    public Boolean isWish(String userEmail, Long productId) {
        // product가 존재한다면, wishProductId를 반환한다
        return wishProductListRepository.existsByUserEmailAndProductId(userEmail, productId);
    }
}
