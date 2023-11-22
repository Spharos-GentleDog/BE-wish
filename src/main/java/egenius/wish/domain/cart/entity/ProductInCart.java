package egenius.wish.domain.cart.entity;

import egenius.wish.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
@Table(name = "product_in_cart")
public class ProductInCart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "product_detail_id", nullable = false)
    private Long productDetailId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "checked", nullable = false)
    private Boolean checked;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    /**
     * 1. 체크 상태 업데이트
     * 2. 상품 수량 변경
     */
    public void updateChecked(Boolean checked) {
        this.checked = checked;
    }

    public void updateCount(Integer count) {
        this.count = count;
    }
}
