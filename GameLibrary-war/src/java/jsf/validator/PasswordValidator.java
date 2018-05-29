/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
    private static final Pattern PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]+$");
    private static final String PASSWORD_SYMBOLS_REQUIREMENT = "Must contain only and at least 1 Uppercase, 1Lowercase and 1 Number!";
    private static final int MIN_LEN = 8;
    private static final String PASSWORD_LENGTH_REQUIREMENT = String.format("Must be at least %d characters long!", MIN_LEN);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        CharSequence stringValue = (CharSequence) value;
        if (stringValue.length() < MIN_LEN) {
            FacesMessage facesMessage = new FacesMessage(PASSWORD_LENGTH_REQUIREMENT);

            throw new ValidatorException(facesMessage);
        }
        
        Matcher matcher = PATTERN.matcher(stringValue);
        if (!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(PASSWORD_SYMBOLS_REQUIREMENT);

            throw new ValidatorException(facesMessage);
        }
    }

}
