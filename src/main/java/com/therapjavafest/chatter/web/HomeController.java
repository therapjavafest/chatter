package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.service.ChatterService;
import com.therapjavafest.chatter.service.ChatterServiceImpl;
import com.therapjavafest.chatter.util.AuthenticationHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.therapjavafest.chatter.util.Constants.*;

/**
 * @author Bazlur Rahman Rokon
 * @author Rony Gomes
 * @since 1.0
 */
@WebServlet(HOME_PAGE_URL)
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthenticationHelper.isLoggedIn(req)) {
            ChatterService chatterService = new ChatterServiceImpl();
            req.setAttribute("chatters", chatterService.getChatters());
            req.getRequestDispatcher(HOME_VIEW_PATH).forward(req, resp);
        } else {
            resp.sendRedirect(LOGIN_PAGE_URL);
        }
    }
}
