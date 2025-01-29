package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class EmailAlreadyExistsException extends AniforuException {
    public EmailAlreadyExistsException() {
        super(AuthErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
