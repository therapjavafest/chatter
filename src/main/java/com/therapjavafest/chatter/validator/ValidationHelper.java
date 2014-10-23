package com.therapjavafest.chatter.validator;

import static com.therapjavafest.chatter.util.Constants.EMAIL_PATTERN;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class ValidationHelper {

    public static boolean isValidEmail(String email) {

        return email.matches(EMAIL_PATTERN);
    }

    public static boolean isNotEmpty(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
