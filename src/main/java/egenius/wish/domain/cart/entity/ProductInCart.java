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
public class ProductInCart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "count")
    private Integer count;

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "brand_name")
    private String brandName;
}
