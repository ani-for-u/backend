package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class LoginOrPasswordMismatchException extends AniforuException {
    public LoginOrPasswordMismatchException() {
        super(AuthErrorCode.LOGINID_OR_PASSWORD_MISMATCH);
    }
}
