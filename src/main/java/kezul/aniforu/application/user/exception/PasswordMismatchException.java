package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.FighterException;
import kezul.aniforu.domain.user.exception.UserErrorCode;

public class PasswordMismatchException extends FighterException {
    public PasswordMismatchException() {
        super(UserErrorCode.PASSWORD_MISMATCH);
    }
}
