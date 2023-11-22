package egenius.wish.domain.cart.entity;

import egenius.wish.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "product_detail_id")
    private Long product_detail_id;

    @Column(name = "count")
    private Integer count;

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "brand_name")
    private String brandName;
}
