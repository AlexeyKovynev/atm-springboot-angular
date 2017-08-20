package name.javalex.springboot.validator;

import name.javalex.springboot.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    
    private final static String USERNAME_FIELD = "username";
    private final static String PASS_FIELD = "password";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME_FIELD, "required.field");
        if (user.getUsername().length() != 16) {
            errors.rejectValue(USERNAME_FIELD, "credit.card.number.length");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASS_FIELD, "required.field");
        if (user.getPassword().length() != 4) {
            errors.rejectValue(PASS_FIELD, "pin.length");
        }
    }
}