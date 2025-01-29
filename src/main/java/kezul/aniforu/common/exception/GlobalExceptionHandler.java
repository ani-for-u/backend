package kezul.aniforu.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kezul.aniforu.domain.user.exception.AuthErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final HttpServletResponse response;
    private final HttpServletRequest request;
    private final MessageSource messageSource;

    @ExceptionHandler(AniforuException.class)
    public void handleFighterException(AniforuException e) {
        setResponse(e.getErrorCode());
    }

    @ExceptionHandler(AuthenticationException.class)
    public void handleAuthenticationException() {
        System.out.println("========================");
        setResponse(AuthErrorCode.LOGINID_OR_PASSWORD_MISMATCH);
    }

    private void setResponse(ErrorCode errorCode) {
        response.setStatus(errorCode.getStatus().value());
        request.setAttribute("message", errorCode.getMessage(messageSource));
    }
}
