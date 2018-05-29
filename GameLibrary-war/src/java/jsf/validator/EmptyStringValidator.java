/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import session.UserFacade;

@FacesValidator("emptyStringValidator")
public class EmptyStringValidator implements Validator {

    private static final Pattern EMPTY_PATTERN = Pattern.compile("^\\s*$");
    private static final String FIELD_REQUIRED = "Field required!";

    @EJB
    private UserFacade userFacade;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        CharSequence stringValue = (CharSequence) value;

        Matcher matcher = EMPTY_PATTERN.matcher(stringValue);
        if (matcher.matches()) {
            throw new ValidatorException(new FacesMessage(FIELD_REQUIRED));
        }
    }

}
