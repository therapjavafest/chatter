package com.therapjavafest.chatter.repository;

import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.util.DatabaseTemplate;
import com.therapjavafest.chatter.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/21/14.
 */
public class JdbcUserDaoImpl implements UserDao {

    @Override
    public void saveUser(User user) {
        DatabaseTemplate.executeInsertQuery("INSERT INTO User (first_name, last_name, email_address, password) VALUES (?,?,?,?)",
                user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPassword());
    }

    @Override
    public User findUserByEmailAddress(String emailAddress) {

        List<User> users = DatabaseTemplate.queryForObject("select * from User where email_address = '" + emailAddress + "'", new ObjectRowMapper<User>() {
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

        if (users.size() != 0) {
            return users.get(0);
        }

        return null;
    }
}
