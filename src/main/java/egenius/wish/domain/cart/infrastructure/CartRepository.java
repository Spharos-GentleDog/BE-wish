package egenius.wish.domain.cart.infrastructure;

import egenius.wish.domain.cart.entity.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<ProductInCart, Long> {
    /**
     * cart
     * 1. 유저 이메일로 조회
     * 2. 중복 조회
     */
    List<ProductInCart> findByUserEmail(String userEmail);

    Boolean existsByProductDetailId(Long productDetailId);

}
