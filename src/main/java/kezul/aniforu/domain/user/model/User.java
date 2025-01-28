package kezul.aniforu.domain.user.model;

import jakarta.persistence.*;
import kezul.aniforu.domain.user.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "community_users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
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

    public static User of(String loginId, String password, String email, String nickname, UserRole role) {
        User user = new User();
        user.loginId = loginId;
        user.password = password;
        user.email = email;
        user.nickname = nickname;
        user.role = role;
        return user;
    }
}
