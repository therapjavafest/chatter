package com.therapjavafest.chatter.repository;

import com.therapjavafest.chatter.model.User;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 10/21/14.
 */
public interface UserDao {

    public void saveUser(User user);

    public User findUserByEmailAddress(String emailAddress);
}
