package kezul.fighting.application.user.exception;

import kezul.fighting.common.exception.FighterException;
import kezul.fighting.domain.user.exception.UserErrorCode;

public class LoginIdNotExistsException extends FighterException {
    public LoginIdNotExistsException() {
        super(UserErrorCode.LOGINID_NOT_EXISTS);
    }
}
