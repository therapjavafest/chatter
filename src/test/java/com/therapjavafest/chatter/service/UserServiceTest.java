package com.therapjavafest.chatter.service;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.repository.JdbcUserDaoImpl;
import com.therapjavafest.chatter.repository.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    private User user;
    private final String FIRST_NAME = "demo";
    private final String LAST_NAME = "demo";
    private final String EMAIL_ADDRESS = "demo@demo.com";
    private final String PASSWORD = "12345";

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        UserDao userDao = mock(JdbcUserDaoImpl.class);
        userService = new UserServiceImpl(userDao);

        user = new User();

        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setEmailAddress(EMAIL_ADDRESS);
        user.setPassword(PASSWORD);

        Mockito.when(userDao.findUserByEmailAddress(EMAIL_ADDRESS)).thenReturn(user);
    }


    @Test
    public void testVerifyUser() throws Exception {
        User verifiedUser = userService.verifyUser(user);
        assertNotNull(verifiedUser);
        assertEquals(FIRST_NAME, verifiedUser.getFirstName());
    }
}