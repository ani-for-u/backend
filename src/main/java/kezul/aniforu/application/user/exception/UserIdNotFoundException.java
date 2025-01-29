package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class UserIdNotFoundException extends AniforuException {
    public UserIdNotFoundException() {
        super(AuthErrorCode.USERID_NOT_FOUND);
    }
}
