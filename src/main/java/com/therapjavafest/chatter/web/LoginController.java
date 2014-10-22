package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.service.UserService;
import com.therapjavafest.chatter.service.UserServiceImpl;
import com.therapjavafest.chatter.util.Constants;
import com.therapjavafest.chatter.validator.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.therapjavafest.chatter.util.Constants.*;

/**
 * @author Rony Gomes
 * @since 1.0
 */
@WebServlet(LOGIN_PAGE_URL)
public class LoginController extends HttpServlet {

    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_VIEW_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(EMAIL_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);

        if (!LoginValidator.isValid(req, email, password)) {
            req.getRequestDispatcher(LOGIN_VIEW_PATH).forward(req, resp);
            return;
        }

        UserService userService = new UserServiceImpl();
        User currentUser = userService.verifyUser(createUser(email, password));
        if (isAuthenticatedUser(currentUser)) {
            storeUserInSession(req, currentUser);
            resp.sendRedirect(HOME_PAGE_URL);
        } else {
            req.getRequestDispatcher(LOGIN_VIEW_PATH).forward(req, resp);
        }
    }

    private boolean isAuthenticatedUser(User user) {
        return user != null;
    }

    private User createUser(String email, String password) {
        User user = new User();
        user.setEmailAddress(email);
        user.setPassword(password);
        return user;
    }

    private void storeUserInSession(HttpServletRequest request, User user) {
        request.getSession(true).setAttribute(LOGGED_IN_USER_SESSION_KEY, user);
    }
}
