package kezul.aniforu.application.user.service;

import kezul.aniforu.application.user.dto.response.UserSignUpResponseDto;
import kezul.aniforu.domain.user.enums.UserRole;

public interface AuthService {

    UserSignUpResponseDto signUp(String loginId, String password, String nickName, String email, UserRole userRole);
}
