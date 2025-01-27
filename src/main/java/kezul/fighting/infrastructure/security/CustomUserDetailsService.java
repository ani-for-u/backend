package kezul.fighting.infrastructure.security;

import kezul.fighting.application.user.exception.LoginIdNotExistsException;
import kezul.fighting.domain.user.model.User;
import kezul.fighting.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username).orElseThrow(LoginIdNotExistsException::new);
        return new CustomUserDetails(user);
    }
}
