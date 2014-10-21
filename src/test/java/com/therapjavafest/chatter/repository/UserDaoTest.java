package com.therapjavafest.chatter.repository;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.util.DatabaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDaoTest {
    private User user;
    private final String FIRST_NAME = "demo";
    private final String LAST_NAME = "demo";
    private final String EMAIL_ADDRESS = "demo@demo.com";
    private final String PASSWORD = "12345";

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setEmailAddress(EMAIL_ADDRESS);
        user.setPassword(PASSWORD);

        userDao = new JdbcUserDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        clearDb();
    }

    @Test
    public void testSaveUserAndFindUserByUserName_shouldReturnUser() throws Exception {
        userDao.saveUser(user);
        User user = userDao.findUserByEmailAddress(EMAIL_ADDRESS);

        assertNotNull(user);
        assertEquals(EMAIL_ADDRESS, user.getEmailAddress());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(PASSWORD, user.getPassword());
    }


    private void clearDb() {
        DatabaseTemplate.delete("delete from User");
    }
}
