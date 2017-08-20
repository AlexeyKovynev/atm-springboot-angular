package name.javalex.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import name.javalex.springboot.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findOneByUsername(String username);

}
