package name.javalex.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import name.javalex.springboot.entity.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
