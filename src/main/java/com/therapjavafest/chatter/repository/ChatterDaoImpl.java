package com.therapjavafest.chatter.repository;

import com.therapjavafest.chatter.model.Chatter;
import com.therapjavafest.chatter.model.User;
import com.therapjavafest.chatter.util.DatabaseTemplate;
import com.therapjavafest.chatter.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class ChatterDaoImpl implements ChatterDao {
    private static final String FIND_QUERY = "SELECT c.id, c.chatter_text, c.created, c.created_by, u.first_name, u.last_name " +
                                             "FROM chatters AS c " +
                                             "JOIN User AS u " +
                                             "ON c.created_by = u.id " +
                                             "ORDER BY c.created DESC";
    private static final String INSERT_QUERY = "INSERT INTO chatters (chatter_text, created, created_by) VALUES (?, NOW(), ?)";

    @Override
    public List<Chatter> getChatters() {
        return DatabaseTemplate.queryForObject(FIND_QUERY, chatterRowMapper);
    }

    @Override
    public void save(Chatter chatter) {
        DatabaseTemplate.executeInsertQuery(INSERT_QUERY, chatter.getText(), chatter.getCreatedBy().getId());
    }

    private static final ObjectRowMapper<Chatter> chatterRowMapper = new ObjectRowMapper<Chatter>() {
        @Override
        public Chatter mapRowToObject(ResultSet resultSet) throws SQLException {

            Chatter chatter = new Chatter();
            chatter.setId(resultSet.getInt("id"));
            chatter.setText(resultSet.getString("chatter_text"));
            chatter.setCreated(resultSet.getDate("created"));

            User user = new User();
            user.setId(resultSet.getInt("created_by"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            chatter.setCreatedBy(user);

            return chatter;
        }
    };
}