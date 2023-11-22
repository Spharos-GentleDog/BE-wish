package egenius.wish.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    /**
     * 200: 요청 성공
     **/
    SUCCESS(HttpStatus.OK,true, 200, "요청에 성공하였습니다."),

    /**
     * 900: 기타 에러
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"),

    /**
     * 5000 : Cart & WishProductList Service Error
     */
    NO_DATA(HttpStatus.BAD_REQUEST, false, 6001, "존재하지 않는 정보입니다"),
    ALREADY_ADDED_PRODUCT(HttpStatus.CONFLICT, false, 6002, "이미 장바구니에 존재하는 상품입니다"),

    ;


    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private String message;
}
