package kezul.fighting.application.user.exception;

import kezul.fighting.common.exception.FighterException;
import kezul.fighting.domain.user.exception.UserErrorCode;

public class PasswordMismatchException extends FighterException {
    public PasswordMismatchException() {
        super(UserErrorCode.PASSWORD_MISMATCH);
    }
}
