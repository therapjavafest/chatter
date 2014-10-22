package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.service.ChatterService;
import com.therapjavafest.chatter.service.ChatterServiceImpl;
import com.therapjavafest.chatter.service.UserService;
import com.therapjavafest.chatter.service.UserServiceImpl;
import com.therapjavafest.chatter.util.AuthenticationHelper;
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
            AuthenticationHelper.login(req, currentUser);

            ChatterService chatterService = new ChatterServiceImpl();
            req.setAttribute("chatters", chatterService.getChatters());
            resp.sendRedirect(HOME_PAGE_URL);
        } else {
            req.setAttribute("login_failed", "Invalid username/password");
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
}
