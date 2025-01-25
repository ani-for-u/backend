package kezul.fighting.presentation.auth.dto.request;

import kezul.fighting.domain.user.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserSignUpRequestDto {

    private String loginId;
    private String password;
    private String email;
    private String nickname;
    private UserRole userRole;

}
