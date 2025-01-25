package kezul.fighting.application.user.service;

import kezul.fighting.application.user.dto.response.UserSignUpResponseDto;
import kezul.fighting.domain.user.enums.UserRole;

public interface AuthService {

    UserSignUpResponseDto signUp(String loginId, String password, String nickName, String email, UserRole userRole);
}
