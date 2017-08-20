package name.javalex.springboot.service.impl;

import name.javalex.springboot.service.SecurityContextService;
import name.javalex.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import name.javalex.springboot.entity.User;
import name.javalex.springboot.repository.UserRepository;

import java.util.Optional;
import java.util.function.Consumer;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final SecurityContextService securityContextService;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           SecurityContextService securityContextService) {
        this.userRepository = userRepository;
        this.securityContextService = securityContextService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.findOneByUsername(username);
        final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        user.ifPresent(new Consumer<User>() {
            @Override
            public void accept(User user1) {
                detailsChecker.check(user1);
            }
        });
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
    }


    public String getAuthenticatedUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @Override
    public Integer getAccountBalance() {
        return securityContextService.currentUser().get().getBalance();
    }


}
