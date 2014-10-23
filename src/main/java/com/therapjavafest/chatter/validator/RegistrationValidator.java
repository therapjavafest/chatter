package com.therapjavafest.chatter.validator;

import com.therapjavafest.chatter.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 10/23/14.
 */
public class RegistrationValidator {

    public static boolean isValid(HttpServletRequest request, User user) {
        boolean isValid = true;

        if (ValidationHelper.isEmpty(user.getFirstName())) {
            request.setAttribute("firstNameError", "First Name is required");
            isValid = false;
        }

        if (ValidationHelper.isEmpty(user.getLastName())) {
            request.setAttribute("lastNameError", "Last Name is required");
            isValid = false;
        }

        if (ValidationHelper.isEmpty(user.getEmailAddress())) {
            request.setAttribute("emailError", "Email is required");
            isValid = false;
        } else if (!ValidationHelper.isValidEmail(user.getEmailAddress())){
            request.setAttribute("emailError", "Invalid email");
            isValid = false;
        }

        if (ValidationHelper.isEmpty(user.getPassword())) {
            request.setAttribute("passwordError", "Password is required");
            isValid = false;
        }else if (ValidationHelper.isEmpty(user.getPasswordConfirmed())) {
            request.setAttribute("passwordError", "Confirmed Password is required");
            isValid = false;
        }else if (!user.getPassword().equals(user.getPasswordConfirmed())) {
            request.setAttribute("passwordConfirmedError", "Password & Confirmed Password did not match");
            isValid = false;
        }

        return isValid;
    }
}
