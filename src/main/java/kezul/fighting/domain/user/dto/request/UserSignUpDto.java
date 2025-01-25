package kezul.fighting.domain.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDto {

    private String loginId;
    private String password;
    private String email;
    private String nickname;
}
