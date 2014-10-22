package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.util.Constants;

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

@WebServlet(REGISTER_PAGE_URL)
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.VIEWS_ROOT + "register.jsp").forward(req, resp);
    }
}
