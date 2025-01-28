package kezul.aniforu.application.user.exception;

import kezul.aniforu.common.exception.FighterException;
import kezul.aniforu.domain.user.exception.UserErrorCode;

public class EmailAlreadyExistsException extends FighterException {
    public EmailAlreadyExistsException() {
        super(UserErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
