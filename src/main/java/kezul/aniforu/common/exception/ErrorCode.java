package kezul.aniforu.common.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getStatus();
    String getCode();
    String getMessage(MessageSource messageSource);
}
