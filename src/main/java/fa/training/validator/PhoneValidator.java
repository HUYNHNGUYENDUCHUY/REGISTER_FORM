package fa.training.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String>{
    public void initialize(Phone paramA){

    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneNo == null){
            return false;
        }
        return phoneNo.matches("^([[+?84]|0])+([0-9]{9})$");
    }
}
