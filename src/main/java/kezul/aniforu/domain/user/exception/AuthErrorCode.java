package kezul.aniforu.domain.user.exception;

import kezul.aniforu.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;

@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.email.already-exists"),
    NICKNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.nickname.already-exists"),
    LOGINID_ALREADY_EXISTS(HttpStatus.CONFLICT, "auth.loginid.already-exists"),
    LOGINID_NOT_EXISTS(HttpStatus.BAD_REQUEST, "auth.loginid.not-exists"),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "auth.password.mismatch"),
    LOGINID_OR_PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "auth.loginid.or.password.mismatch"),
    USERID_NOT_FOUND(HttpStatus.NOT_FOUND, "auth.user.not-found")
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