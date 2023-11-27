package egenius.wish.domain.cart.webdto.out;

import egenius.wish.domain.cart.dtos.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.TreeMap;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetCheckedCartWebOutDto {
    // 브랜드별로 정렬된 List
    @Builder.Default
    TreeMap<String, List<ProductDto>> checkedCart = new TreeMap<>();

}
