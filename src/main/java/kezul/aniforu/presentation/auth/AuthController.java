package kezul.aniforu.presentation.auth;

import kezul.aniforu.application.user.dto.response.UserSignUpResponseDto;
import kezul.aniforu.application.user.service.AuthService;
import kezul.aniforu.presentation.auth.dto.request.UserSignUpRequestDto;
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
