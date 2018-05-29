/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.validator;

import entity.User;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import session.UserFacade;

@FacesValidator("usernameRegisterValidator")
public class UsernameRegisterValidator implements Validator {

    private static final String USERNAME_EXISTS = "Username exists!";

    @EJB
    private UserFacade userFacade;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        new EmptyStringValidator().validate(context, component, value);
        CharSequence stringValue = (CharSequence) value;

        User user = userFacade.findByName(stringValue.toString());
        if (user != null) {
            throw new ValidatorException(new FacesMessage(USERNAME_EXISTS));
        }
    }

}
