package kezul.aniforu.application.user.service;

import kezul.aniforu.application.user.dto.response.UserSignUpResponseDto;
import kezul.aniforu.application.user.exception.EmailAlreadyExistsException;
import kezul.aniforu.application.user.exception.LoginIdAlreadyExistsException;
import kezul.aniforu.application.user.exception.NicknameAlreadyExistsException;
import kezul.aniforu.domain.user.enums.UserRole;
import kezul.aniforu.domain.user.model.User;
import kezul.aniforu.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public UserSignUpResponseDto signUp(String loginId, String password, String nickname, String email, UserRole role) {

        // 1. 로그인 아이디 중복 검사
        if (userRepository.existsUserByLoginId(loginId)) {
            throw new LoginIdAlreadyExistsException();
        }

        // 2. nickname 중복 검사
        if (userRepository.existsUserByNickname(nickname)) {
            throw new NicknameAlreadyExistsException();
        }

        // 3. email 중복 검사
        if (userRepository.existsUserByEmail(email)) {
            // 에러 처리
            throw new EmailAlreadyExistsException();
        }

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        User user = User.of(loginId, encodedPassword, email, nickname, role);
        User savedUser = userRepository.save(user);
        return UserSignUpResponseDto.from(savedUser);
    }
}
