package kezul.aniforu.application.user.dto.response;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String accessToken;

    private LoginResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public static LoginResponseDto of(String accessToken) {
        return new LoginResponseDto(accessToken);
    }
}
