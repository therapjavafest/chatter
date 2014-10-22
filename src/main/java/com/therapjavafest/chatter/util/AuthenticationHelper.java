package com.therapjavafest.chatter.util;

import com.therapjavafest.chatter.model.User;

import javax.servlet.http.HttpServletRequest;

import static com.therapjavafest.chatter.util.Constants.LOGGED_IN_USER_SESSION_KEY;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class AuthenticationHelper {

    public static void login(HttpServletRequest request, User user) {
        request.getSession(true).setAttribute(LOGGED_IN_USER_SESSION_KEY, user);
    }

    public static void logout(HttpServletRequest request) {
        request.getSession(true).removeAttribute(LOGGED_IN_USER_SESSION_KEY);
    }
}
