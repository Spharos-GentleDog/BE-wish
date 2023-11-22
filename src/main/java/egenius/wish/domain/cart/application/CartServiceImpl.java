package egenius.wish.domain.cart.application;

import com.querydsl.jpa.impl.JPAQueryFactory;
import egenius.wish.domain.cart.dtos.ProductDto;
import egenius.wish.domain.cart.dtos.in.AddProductInDto;
import egenius.wish.domain.cart.dtos.in.UpdateCheckedInDto;
import egenius.wish.domain.cart.dtos.out.GetCartOutDto;
import egenius.wish.domain.cart.entity.ProductInCart;
import egenius.wish.domain.cart.infrastructure.CartRepository;
import egenius.wish.global.common.exception.BaseException;
import egenius.wish.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Cart
     * 1. 장바구니에 상품 추가
     * 2. 장바구니 조회
     * 3. 체크 선택/취소
     * 4. 장바구니 상품 삭제
     */

    // 1. 장바구니에 상품 추가
    @Override
    public void addProduct(AddProductInDto inDto, String userEmail) {
        // 중복 조회
        if (cartRepository.existsByProductDetailId(inDto.getProductDetailId()) == true) {
            throw new BaseException(BaseResponseStatus.ALREADY_ADDED_PRODUCT);
        }
        // 중복되지 않았다면 추가
        inDto.setUserEmail(userEmail);
        ProductInCart productInCart = modelMapper.map(inDto, ProductInCart.class);
        cartRepository.save(productInCart);
    }

    @Override
    @Transactional(readOnly = true)
    public GetCartOutDto getCart(String userEmail) {
        // userEmail로 cart 조회
        List<ProductInCart> productInCart = cartRepository.findByUserEmail(userEmail);

        // 상품을 브랜드별로 분류 -> key:브랜드이름, value: 상품dto리스트
        TreeMap<String, List<ProductDto>> byBrand = new TreeMap<>();
        productInCart.forEach(product ->{
            String brandName = product.getBrandName();

            // productDto 생성
            ProductDto productDto = ProductDto.builder()
                    .productDetailId(product.getProductDetailId())
                    .count(product.getCount())
                    .checked(product.getChecked())
                    .productInCartId(product.getId())
                    .build();

            // 브랜드 이름에 맞춰서 저장
            List<ProductDto> productDtoList;
            if (byBrand.containsKey(brandName) == true) {
                productDtoList = byBrand.get(brandName);
                productDtoList.add(productDto);
            } else {
                productDtoList = new ArrayList<>();
                productDtoList.add(productDto);
            }
            byBrand.put(brandName, productDtoList);
        });

        // GetCartOutDto 생성 및 return
        return new GetCartOutDto(byBrand);
    }

    // 3. 체크 선택/취소
    @Override
    public void updateChecked(UpdateCheckedInDto inDto) {
        // inDto의 모든 상품의 check 상태를 변경
        inDto.getChangedCheckedList().forEach(product ->{
            // id로 조회
            ProductInCart productInCart = cartRepository.findById(product.getProductInCartId())
                    .orElseThrow(()-> new BaseException(BaseResponseStatus.NO_DATA));
            // check 업데이트
            productInCart.updateChecked(product.getChecked());
        });
    }

    // 4. 장바구니 상품 삭제
    @Override
    public void deleteProduct(Long productInCartId) {
        cartRepository.deleteById(productInCartId);
    }
}
