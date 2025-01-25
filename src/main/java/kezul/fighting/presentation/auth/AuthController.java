package kezul.fighting.presentation.auth;

import kezul.fighting.application.user.dto.response.UserSignUpResponseDto;
import kezul.fighting.application.user.service.AuthService;
import kezul.fighting.presentation.auth.dto.request.UserSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpDto) {
        return authService.signUp(userSignUpDto.getLoginId(), userSignUpDto.getPassword(), userSignUpDto.getNickname(), userSignUpDto.getEmail(), userSignUpDto.getUserRole());
    }

}
