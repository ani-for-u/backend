package kezul.aniforu.infrastructure.user.repository;

import kezul.aniforu.domain.user.model.User;
import kezul.aniforu.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existsUserByLoginId(String loginId) {
        return userJpaRepository.existsUserByLoginId(loginId);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userJpaRepository.existsUserByEmail(email);
    }

    @Override
    public boolean existsUserByNickname(String nickname) {
        return userJpaRepository.existsUserByNickname(nickname);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return userJpaRepository.findByLoginId(loginId);
    }


}
