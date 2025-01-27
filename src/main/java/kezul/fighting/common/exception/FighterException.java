package kezul.fighting.common.exception;

import lombok.Getter;

@Getter
public class FighterException extends RuntimeException {
    private final ErrorCode errorCode;

    public FighterException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
