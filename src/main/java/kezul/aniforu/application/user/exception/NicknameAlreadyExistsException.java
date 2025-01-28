package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.FighterException;
import kezul.aniforu.domain.user.exception.UserErrorCode;

public class NicknameAlreadyExistsException extends FighterException {
    public NicknameAlreadyExistsException() {
        super(UserErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
