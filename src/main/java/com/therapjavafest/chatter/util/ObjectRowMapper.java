package com.therapjavafest.chatter.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/21/14.
 */
public interface ObjectRowMapper<E> {
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}
