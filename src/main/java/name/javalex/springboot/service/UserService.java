package name.javalex.springboot.service;

public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {

    String getAuthenticatedUsername();

    Integer getAccountBalance();

}
