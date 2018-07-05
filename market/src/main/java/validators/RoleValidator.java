package validators;

import model.Authority;
import utils.EnumUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<UserRole, String> {
    public void initialize(UserRole constraint) {
    }

    public boolean isValid(String role, ConstraintValidatorContext context) {
        try {
            EnumUtils.valueOf(Authority.Role.class, role).orElseThrow(IllegalArgumentException::new);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
