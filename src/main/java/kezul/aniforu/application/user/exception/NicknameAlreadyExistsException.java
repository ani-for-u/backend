package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.AniforuException;
import kezul.aniforu.domain.user.exception.AuthErrorCode;

public class NicknameAlreadyExistsException extends AniforuException {
    public NicknameAlreadyExistsException() {
        super(AuthErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
