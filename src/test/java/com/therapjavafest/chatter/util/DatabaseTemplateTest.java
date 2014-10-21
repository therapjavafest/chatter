package com.therapjavafest.chatter.util;

import com.therapjavafest.chatter.model.User;
import org.junit.After;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DatabaseTemplateTest {

    @After
    public void tearDown() throws Exception {
        DatabaseTemplate.delete("delete from User");
    }

    @Test
    public void testExecute_shouldNotThrowException() throws Exception {
        DatabaseTemplate.execute("select * from User where email_address = 'bazlur@bazlur.com'");
    }

    @Test
    public void testQueryForObject_shouldReturnOneUser() throws Exception {
        DatabaseTemplate.executeInsertQuery("INSERT INTO User (first_name, last_name, email_address, password) VALUES (?,?,?,?)", "Bazlur", "Rahman", "bazlur@bazlur.com", "12345");

        List<User> users = DatabaseTemplate.queryForObject("select * from User where email_address = 'bazlur@bazlur.com'", new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmailAddress(resultSet.getString("email_address"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        });

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("bazlur@bazlur.com", users.get(0).getEmailAddress());
    }

    @Test
    public void testExecuteInsertQuery_shouldNotThrowException() throws Exception {
        DatabaseTemplate.executeInsertQuery("INSERT INTO User (first_name, last_name, email_address, password) VALUES (?,?,?,?)",
                "Bazlur", "Rahman", "bazlur@therapservices.net", "12345");
    }
}