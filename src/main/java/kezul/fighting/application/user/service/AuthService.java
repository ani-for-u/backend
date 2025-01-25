package kezul.fighting.application.user.service;

import kezul.fighting.domain.user.enums.UserRole;

public interface AuthService {

    void signUp(String loginId, String password, String nickName, String email);
}
