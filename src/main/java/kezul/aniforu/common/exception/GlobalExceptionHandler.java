package kezul.aniforu.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final HttpServletResponse response;
    private final HttpServletRequest request;
    private final MessageSource messageSource;

    @ExceptionHandler(AniforuException.class)
    public void handleAniforuException(AniforuException e) {
        setResponse(e.getErrorCode());
    }


    private void setResponse(ErrorCode errorCode) {
        response.setStatus(errorCode.getStatus().value());
        request.setAttribute("message", errorCode.getMessage(messageSource));
    }
}
