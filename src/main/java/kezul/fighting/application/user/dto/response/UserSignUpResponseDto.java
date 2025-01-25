package kezul.fighting.application.user.dto.response;

import kezul.fighting.domain.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
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
