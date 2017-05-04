package net.arxemond.springsecurityapp.vaildator;

import net.arxemond.springsecurityapp.model.User;
import net.arxemond.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

/**
 * Validate for {@link net.arxemond.springsecurityapp.model.User} class.
 * Implements {@link Validator} interface.
 *
 * @author arxemond777 <1arxemond1@gmail.com>
 * @version 1.0
 */

@Component
public class UserValidator implements Validator
{
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass); // Подверждаем, что является экземпляром User
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        /**
         * Ошибки для Юзвера
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required"); // Если ничего не ввели, то вернет, что обязательно. Из /resources/validation.properties

        if (user.getUsername().length() < 8 || user.getUsername().length() > 32) // Не принимаем и выводим ошибку. /resources/validation.properties
            errors.rejectValue("username", "Size.userForm.username");

        if (userService.findByUsername(user.getUsername()) != null) // If exist such user
            errors.rejectValue("username", "Duplicate.userForm.username");

        /**
         * Ошибки для пасса
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required"); // Если ничего не ввели, то вернет, что обязательно

        if (user.getUsername().length() < 8 || user.getUsername().length() > 32) // Не принимаем и выводим ошибку. /resources/validation.properties
            errors.rejectValue("password", "Size.userForm.password");

        if (!user.getConfirmPassword().equals(user.getPassword())) // Если пароль и пароль_подтвержения не равны
            errors.rejectValue("password", "Different.userForm.password");
    }
}
