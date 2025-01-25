package kezul.fighting.domain.user.model;

import jakarta.persistence.*;
import kezul.fighting.domain.user.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private int point;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public static User of(String loginId, String password, String email, String nickname) {
        User user = new User();
        user.loginId = loginId;
        user.password = password;
        user.email = email;
        user.nickname = nickname;
        return user;
    }
}
