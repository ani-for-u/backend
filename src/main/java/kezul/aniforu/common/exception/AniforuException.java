package kezul.aniforu.common.exception;

import lombok.Getter;

@Getter
public class AniforuException extends RuntimeException {
    private final ErrorCode errorCode;

    public AniforuException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
