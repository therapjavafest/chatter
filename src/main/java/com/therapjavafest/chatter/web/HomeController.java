package com.therapjavafest.chatter.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.therapjavafest.chatter.util.Constants.*;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/20/14.
 */
@WebServlet(HOME_PAGE_URL)
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("plain/text");
        resp.getOutputStream().println("Hello world!");
    }
}
