package name.javalex.springboot;

import name.javalex.springboot.configuration.SHA256PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAngular4Application {
    public static void main(String[] args) {

//        //Just a stupid way to encode password (to insert encoded to DB)
//        SHA256PasswordEncoder passwordEncoder = new SHA256PasswordEncoder();
//        System.out.println(passwordEncoder.encode("0000"));

        SpringApplication.run(SpringAngular4Application.class, args);
    }


}
