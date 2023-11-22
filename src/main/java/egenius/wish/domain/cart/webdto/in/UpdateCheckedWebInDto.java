package egenius.wish.domain.cart.webdto.in;

import egenius.wish.domain.cart.dtos.CheckedDto;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateCheckedWebInDto {
    private List<CheckedDto> changedCheckedList;
}
