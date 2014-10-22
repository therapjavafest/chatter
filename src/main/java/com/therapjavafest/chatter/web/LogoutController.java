package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.util.AuthenticationHelper;

import static com.therapjavafest.chatter.util.Constants.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rony Gomes
 * @since 1.0
 */
@WebServlet(LOGOUT_PAGE_URL)
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthenticationHelper.logout(req);
        resp.sendRedirect(LOGIN_PAGE_URL);
    }
}
