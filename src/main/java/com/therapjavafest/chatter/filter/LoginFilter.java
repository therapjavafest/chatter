package com.therapjavafest.chatter.filter;


import com.therapjavafest.chatter.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/24/14.
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if ((session == null || session.getAttribute(Constants.AUTH_KEY) == null)
                && (requestedUri.contains("home") || requestedUri.contains("logout"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        } else if (session != null && session.getAttribute(Constants.AUTH_KEY) != null
                && (requestedUri.contains("login") || requestedUri.contains("register"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("home");
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
