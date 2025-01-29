package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class LoginIdAlreadyExistsException extends AniforuException {
    public LoginIdAlreadyExistsException() {
        super(AuthErrorCode.LOGINID_ALREADY_EXISTS);
    }
}
