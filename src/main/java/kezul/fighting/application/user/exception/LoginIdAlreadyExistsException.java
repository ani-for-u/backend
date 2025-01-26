package kezul.fighting.application.user.exception;

import kezul.fighting.common.exception.FighterException;
import kezul.fighting.domain.user.exception.UserErrorCode;

public class LoginIdAlreadyExistsException extends FighterException {
    public LoginIdAlreadyExistsException() {
        super(UserErrorCode.LOGINID_ALREADY_EXISTS);
    }
}
