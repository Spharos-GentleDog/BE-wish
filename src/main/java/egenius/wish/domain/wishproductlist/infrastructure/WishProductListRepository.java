package egenius.wish.domain.wishproductlist.infrastructure;

import egenius.wish.domain.wishproductlist.entity.WishProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishProductListRepository extends JpaRepository<WishProductList, Long> {
    /**
     * 1. userEmail로 찜한 상품 리스트 조회
     * 2. userEmail과 ProductId로 찜한상품 단건 조회
     * 3. 찜한상품 삭제
     * 4. userEmail과 ProductId로 중복여부 조회
     */

    List<WishProductList> findAllByUserEmail(String userEmail);

    Optional<WishProductList> findByUserEmailAndProductId(String userEmail, Long productId);

    void deleteByWishProductListId(Long id);

    Boolean existsByUserEmailAndProductId(String userEmail, Long productId);


}
