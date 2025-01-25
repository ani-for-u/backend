package kezul.fighting.domain.user.repository;


import kezul.fighting.domain.user.model.User;

public interface UserRepository {

    boolean existsUserByLoginId(String loginId);
    boolean existsUserByEmail(String email);
    boolean existsUserByNickname(String nickname);

    User save(User user);
}
