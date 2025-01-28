package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.FighterException;
import kezul.aniforu.domain.user.exception.UserErrorCode;

public class LoginIdAlreadyExistsException extends FighterException {
    public LoginIdAlreadyExistsException() {
        super(UserErrorCode.LOGINID_ALREADY_EXISTS);
    }
}
