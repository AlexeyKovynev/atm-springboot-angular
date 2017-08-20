package name.javalex.springboot.repository;


import org.springframework.data.repository.CrudRepository;
import name.javalex.springboot.entity.TransactionCategory;

public interface TransactionCategoryRepository extends CrudRepository<TransactionCategory, Integer> {
}
