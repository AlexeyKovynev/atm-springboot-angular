package name.javalex.springboot.service.impl;

import name.javalex.springboot.service.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import name.javalex.springboot.entity.User;
import name.javalex.springboot.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class SecurityContextServiceImpl implements SecurityContextService {

    private final UserRepository userRepository;

    @Autowired
    public SecurityContextServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findOneByUsername(authentication.getName());
    }
}
