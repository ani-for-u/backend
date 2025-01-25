package kezul.fighting.infrastructure.user.repository;

import kezul.fighting.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {
    boolean existsUserByLoginId(String loginId);
    boolean existsUserByEmail(String email);
    boolean existsUserByNickname(String nickname);
}
