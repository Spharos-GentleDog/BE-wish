package egenius.wish.domain.wishproductlist.infrastructure;

import egenius.wish.domain.wishproductlist.entity.WishProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishProductListRepository extends JpaRepository<WishProductList, Long> {
    List<WishProductList> findAllByUserEmail(String userEmail);

    Optional<WishProductList> findByUserEmailAndProductId(String userEmail, Long productId);

    void deleteByWishProductListId(Long id);
}
