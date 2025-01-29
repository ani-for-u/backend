package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class LoginIdNotExistsException extends AniforuException {
    public LoginIdNotExistsException() {
        super(AuthErrorCode.LOGINID_NOT_EXISTS);
    }
}
