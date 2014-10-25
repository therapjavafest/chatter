package com.therapjavafest.chatter.web;

import com.therapjavafest.chatter.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/25/14.
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }

        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        log.error("Servlet Name ={}, Request Uri ={}, Status Code ={}",servletName, requestUri, statusCode, throwable);

        req.setAttribute("statusCode", statusCode);
        req.getRequestDispatcher(Constants.ERROR_VIEW_PATH).forward(req, resp);
    }
}
