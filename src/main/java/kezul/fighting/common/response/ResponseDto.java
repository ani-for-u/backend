package kezul.fighting.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseDto<T> {

    private ResponseStatus status;
    private String message;
    private T data;

    public static ResponseDto <Void> success(String message) {
        return new ResponseDto<>(ResponseStatus.SUCCESS, message, null);
    }

    public static <T> ResponseDto <T> success(String message, T data) {
        return new ResponseDto<>(ResponseStatus.SUCCESS, message, data);
    }

    public static ResponseDto <Void> error(String message) {
        return new ResponseDto<>(ResponseStatus.ERROR, message, null);
    }
}
