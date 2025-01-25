package kezul.fighting.presentation.auth;

import kezul.fighting.application.user.service.AuthService;
import kezul.fighting.domain.user.dto.request.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserSignUpDto userSignUpDto) {
        authService.signUp(userSignUpDto.getLoginId(), userSignUpDto.getPassword(), userSignUpDto.getNickname(), userSignUpDto.getEmail());
    }

}
