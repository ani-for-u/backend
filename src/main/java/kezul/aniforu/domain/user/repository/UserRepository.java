package kezul.aniforu.domain.user.repository;


import kezul.aniforu.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {

    boolean existsUserByLoginId(String loginId);
    boolean existsUserByEmail(String email);
    boolean existsUserByNickname(String nickname);

    User save(User user);

    Optional<User> findByLoginId(String loginId);
}
