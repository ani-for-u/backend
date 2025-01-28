package kezul.aniforu.common.response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ResponseWrapperAdvice implements ResponseBodyAdvice {

    private final HttpServletResponse httpServletResponse;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType)|| StringHttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        int status = httpServletResponse.getStatus();

        if (status >= 400) {

            HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            String message = (String) httpServletRequest.getAttribute("message");
            System.out.println("message = " + message);
            return ResponseDto.error(message);
        }

        return ResponseDto.success(HttpStatus.valueOf(status).name(), body);
    }
}
