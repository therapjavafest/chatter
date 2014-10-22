package com.therapjavafest.chatter.repository;

import com.therapjavafest.chatter.model.Chatter;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public interface ChatterDao {
    public List<Chatter> findChatters();
    public void save(Chatter chatter);
}
