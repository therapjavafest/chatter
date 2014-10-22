package com.therapjavafest.chatter.validator;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class ValidationHelper {

    public static boolean isValidEmail(String email) {
        return true;
    }

    public static boolean isNotEmpty(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
