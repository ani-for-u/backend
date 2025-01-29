package kezul.aniforu.infrastructure.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kezul.aniforu.application.user.dto.response.LoginResponseDto;
import kezul.aniforu.application.user.exception.LoginOrPasswordMismatchException;
import kezul.aniforu.common.response.ResponseDto;
import kezul.aniforu.domain.user.exception.AuthErrorCode;
import kezul.aniforu.infrastructure.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final MessageSource messageSource;

    public LoginFilter(AuthenticationManager authenticationManager, JwtUtils jwtUtils, MessageSource messageSource) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/auth/login");
        this.jwtUtils = jwtUtils;
        this.messageSource = messageSource;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String username = customUserDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = customUserDetails.getAuthorities();
        GrantedAuthority auth = authorities.iterator().next();
        String role = auth.getAuthority();

        String accessToken = jwtUtils.createJwt(username, role);
        LoginResponseDto loginResponseDto = LoginResponseDto.of(accessToken);
        ResponseDto<LoginResponseDto> responseDto = ResponseDto.success(HttpStatus.OK.name(), loginResponseDto);

        setResponse(response, responseDto);
        response.setStatus(HttpStatus.OK.value());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {

        ResponseDto<Void> responseDto = ResponseDto.error(AuthErrorCode.LOGINID_OR_PASSWORD_MISMATCH.getMessage(messageSource));

        setResponse(response, responseDto);
        response.setStatus(AuthErrorCode.LOGINID_OR_PASSWORD_MISMATCH.getStatus().value());
    }

    private void setResponse(HttpServletResponse response, ResponseDto responseDto) {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
