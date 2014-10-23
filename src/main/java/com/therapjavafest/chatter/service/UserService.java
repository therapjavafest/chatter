package com.therapjavafest.chatter.service;

import com.therapjavafest.chatter.model.User;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/21/14.
 */
public interface UserService {


    public void saveUser(User user);

    public User verifyUser(User user);

    public boolean isEmailAddressAlreadyExist(String emailAddress);
}
