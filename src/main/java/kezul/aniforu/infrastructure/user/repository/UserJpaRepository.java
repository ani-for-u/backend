package kezul.aniforu.infrastructure.user.repository;

import kezul.aniforu.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {
    boolean existsUserByLoginId(String loginId);
    boolean existsUserByEmail(String email);
    boolean existsUserByNickname(String nickname);

    Optional<User> findByLoginId(String loginId);

}
