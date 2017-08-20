package name.javalex.springboot.service;

import name.javalex.springboot.entity.User;

import java.util.Optional;

public interface SecurityContextService {

    Optional<User> currentUser();

}
