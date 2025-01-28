package kezul.aniforu.application.user.dto.response;

import kezul.aniforu.domain.user.model.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserSignUpResponseDto {

    private UUID userId;
    private String loginId;
    private String nickname;

    private UserSignUpResponseDto(User user) {
        this.userId = user.getId();
        this.loginId = user.getLoginId();
        this.nickname = user.getNickname();
    }

    public static UserSignUpResponseDto from(User user) {
        return new UserSignUpResponseDto(user);
    }

}
