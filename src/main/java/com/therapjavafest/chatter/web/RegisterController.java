package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.service.UserService;
import com.therapjavafest.chatter.service.UserServiceImpl;
import com.therapjavafest.chatter.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.therapjavafest.chatter.util.Constants.LOGIN_VIEW_PATH;
import static com.therapjavafest.chatter.util.Constants.REGISTER_PAGE_URL;
import static com.therapjavafest.chatter.util.Constants.REGISTER_VIEW_PATH;

/**
 * @author Rony Gomes
 * @since 1.0
 */

@WebServlet(REGISTER_PAGE_URL)
public class RegisterController extends HttpServlet {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String PASSWORD_CONFIRMED_PARAMETER = "passwordConfirmed";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTER_VIEW_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String emailAddress = req.getParameter(EMAIL_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        String passwordConfirmed = req.getParameter(PASSWORD_CONFIRMED_PARAMETER);

        User user = new User(firstName, lastName, emailAddress, password, passwordConfirmed);

        if (!RegistrationValidator.isValid(req, user)) {
            req.getRequestDispatcher(REGISTER_VIEW_PATH).forward(req, resp);

            return;
        }

        UserService userService = new UserServiceImpl();
        if (userService.isEmailAddressAlreadyExist(user.getEmailAddress())) {
            req.setAttribute("emailError", "Someone already registered with that email Address. Try another?");
            req.getRequestDispatcher(REGISTER_VIEW_PATH).forward(req, resp);

            return;
        }

        userService.saveUser(user);
        req.setAttribute("success", "Congratulations. You've successfully registered! You can login now!");
        req.getRequestDispatcher(LOGIN_VIEW_PATH).forward(req, resp);
    }
}
