package egenius.wish.domain.cart.dtos.in;

import egenius.wish.domain.cart.dtos.CheckedDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCheckedInDto {
    private List<CheckedDto> changedCheckedList;
}
