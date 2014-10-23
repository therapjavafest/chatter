package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.model.Chatter;
import com.therapjavafest.chatter.service.ChatterService;
import com.therapjavafest.chatter.service.ChatterServiceImpl;
import com.therapjavafest.chatter.util.AuthenticationHelper;
import com.therapjavafest.chatter.validator.ValidationHelper;

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

    private static final String CHATTER_PARAMETER = "chatter";

    private ChatterService chatterService;

    public HomeController() {
        chatterService = new ChatterServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthenticationHelper.isLoggedIn(req)) {
            if (req.getSession().getAttribute(SUCCESS_CHATTER_SAVE_SESSION_KEY) != null) {
                req.setAttribute("success.save.chatter", "Chatter successfully saved.");
                req.getSession().removeAttribute(SUCCESS_CHATTER_SAVE_SESSION_KEY);
            }
            req.setAttribute("chatters", chatterService.getChatters());
            req.getRequestDispatcher(HOME_VIEW_PATH).forward(req, resp);
        } else {
            resp.sendRedirect(LOGIN_PAGE_URL);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthenticationHelper.isLoggedIn(req)) {
            String chatter = req.getParameter(CHATTER_PARAMETER);

            if (ValidationHelper.isEmpty(chatter)) {
                req.setAttribute("chatterError", "This chatter appears to be blank. Please write something.");
                req.getRequestDispatcher(HOME_VIEW_PATH).forward(req, resp);

                return;
            }

            if (chatterService.save(createChatter(req, chatter))) {
                req.getSession().setAttribute(SUCCESS_CHATTER_SAVE_SESSION_KEY, true);
                resp.sendRedirect(HOME_PAGE_URL);
            } else {

            }
        } else {
            resp.sendRedirect(LOGIN_PAGE_URL);
        }
    }

    private Chatter createChatter(HttpServletRequest request, String chatterText) {

        Chatter chatter = new Chatter();
        chatter.setText(chatterText);
        chatter.setCreatedBy(AuthenticationHelper.getCurrentUser(request));

        return chatter;
    }
}
