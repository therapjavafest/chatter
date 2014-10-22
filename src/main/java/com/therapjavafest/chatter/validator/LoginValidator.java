package com.therapjavafest.chatter.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class LoginValidator {
    public static boolean isValid(HttpServletRequest request, String email, String password) {
        boolean isValid = true;
        if (ValidationHelper.isEmpty(email)) {
            request.setAttribute("emailError", "Email is required");
            isValid = false;
        } else if (!ValidationHelper.isValidEmail(email)){
            request.setAttribute("emailError", "Invalid email");
            isValid = false;
        }

        if (ValidationHelper.isEmpty(password)) {
            request.setAttribute("passwordError", "Password is required");
            isValid = false;
        }

        return isValid;
    }
}
