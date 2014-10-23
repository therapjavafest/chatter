package com.therapjavafest.chatter.service;

import com.therapjavafest.chatter.model.Chatter;
import com.therapjavafest.chatter.repository.ChatterDao;
import com.therapjavafest.chatter.repository.ChatterDaoImpl;

import java.util.List;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class ChatterServiceImpl implements ChatterService {
    private ChatterDao chatterDao;

    public ChatterServiceImpl() {
        chatterDao = new ChatterDaoImpl();
    }

    @Override
    public List<Chatter> getChatters() {
        return chatterDao.getChatters();
    }

    @Override
    public boolean save(Chatter chatter) {
        try {
            chatterDao.save(chatter);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}
