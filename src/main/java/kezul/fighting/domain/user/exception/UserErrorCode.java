package kezul.fighting.domain.user.exception;

import kezul.fighting.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;

@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.email.already-exists"),
    NICKNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.nickname.already-exists"),
    LOGINID_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.loginid.already-exists"),
    LOGINID_NOT_EXISTS(HttpStatus.BAD_REQUEST, "auth.loginid.not-exists"),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "auth.password.mismatch")
    ;

    private final HttpStatus httpStatus;
    private final String messageKey;

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage(MessageSource messageSource) {
        return messageSource.getMessage(messageKey, null, Locale.getDefault());
    }
}