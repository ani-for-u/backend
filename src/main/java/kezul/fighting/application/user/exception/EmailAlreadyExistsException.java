package kezul.fighting.application.user.exception;

import kezul.fighting.common.exception.FighterException;
import kezul.fighting.domain.user.exception.UserErrorCode;

public class EmailAlreadyExistsException extends FighterException {
    public EmailAlreadyExistsException() {
        super(UserErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
