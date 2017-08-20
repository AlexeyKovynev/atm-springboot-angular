package name.javalex.springboot.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import name.javalex.springboot.entity.User;

import java.util.Optional;

@Component
public interface TokenHandler {

    Optional<UserDetails> parseUserFromToken(String token);

    String createTokenForUser(User user);

}
