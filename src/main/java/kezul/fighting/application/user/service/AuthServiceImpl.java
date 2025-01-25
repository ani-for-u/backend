package kezul.fighting.application.user.service;

import kezul.fighting.application.user.dto.response.UserSignUpResponseDto;
import kezul.fighting.domain.user.enums.UserRole;
import kezul.fighting.domain.user.model.User;
import kezul.fighting.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserSignUpResponseDto signUp(String loginId, String password, String nickname, String email, UserRole role) {


        /**
         * todo
         * 1. 예외 처리
         */

        // 1. 로그인 아이디 중복 검사
        if (userRepository.existsUserByLoginId(loginId)) {
            // 에러 처리;
        }

        // 2. nickname 중복 검사
        if (userRepository.existsUserByNickname(nickname)) {
            // 에러 처리
        }

        // 3. email 중복 검사
        if (userRepository.existsUserByEmail(email)) {
            // 에러 처리
        }

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        User user = User.of(loginId, encodedPassword, email, nickname, role);
        User savedUser = userRepository.save(user);
        return UserSignUpResponseDto.from(savedUser);
    }
}
