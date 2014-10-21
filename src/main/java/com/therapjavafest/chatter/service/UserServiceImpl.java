package com.therapjavafest.chatter.service;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.repository.JdbcUserDaoImpl;
import com.therapjavafest.chatter.repository.UserDao;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/21/14.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new JdbcUserDaoImpl();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User verifyUser(User user) {
        User verifiedUser = userDao.findUserByEmailAddress(user.getEmailAddress());

        if (verifiedUser != null && verifiedUser.getPassword().equals(user.getPassword())) {
            return verifiedUser;
        }

        return null;
    }
}
