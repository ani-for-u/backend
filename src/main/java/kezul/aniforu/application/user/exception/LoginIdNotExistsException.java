package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.FighterException;
import kezul.aniforu.domain.user.exception.UserErrorCode;

public class LoginIdNotExistsException extends FighterException {
    public LoginIdNotExistsException() {
        super(UserErrorCode.LOGINID_NOT_EXISTS);
    }
}
