package com.therapjavafest.chatter.util;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class Constants {
    public static final String VIEWS_ROOT = "./WEB-INF/views/";
    public static final String AUTH_KEY = "loggedInUser";

    public static final String LOGIN_PAGE_URL = "/login";
    public static final String LOGOUT_PAGE_URL = "/logout";
    public static final String HOME_PAGE_URL = "/home";
    public static final String REGISTER_PAGE_URL = "/register";

    private static final String LOGIN_VIEW_NAME = "login.jsp";
    private static final String REGISTER_VIEW_NAME = "register.jsp";
    private static final String HOME_VIEW_NAME = "home.jsp";
    private static final String ERROR_VIEW_NAME = "exception.jsp";

    public static final String LOGIN_VIEW_PATH = VIEWS_ROOT + LOGIN_VIEW_NAME;
    public static final String REGISTER_VIEW_PATH = VIEWS_ROOT + REGISTER_VIEW_NAME;
    public static final String HOME_VIEW_PATH = VIEWS_ROOT + HOME_VIEW_NAME;
    public static final String ERROR_VIEW_PATH = VIEWS_ROOT + ERROR_VIEW_NAME;

    public static final String EMAIL_PATTERN = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

}
