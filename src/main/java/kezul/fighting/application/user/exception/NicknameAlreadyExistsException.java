package kezul.fighting.application.user.exception;

import kezul.fighting.common.exception.FighterException;
import kezul.fighting.domain.user.exception.UserErrorCode;

public class NicknameAlreadyExistsException extends FighterException {
    public NicknameAlreadyExistsException() {
        super(UserErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
