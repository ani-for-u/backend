package kezul.aniforu.presentation.auth.dto.request;

import kezul.aniforu.domain.user.enums.UserRole;
import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    private String loginId;
    private String password;
    private String email;
    private String nickname;
    private UserRole userRole;

}
