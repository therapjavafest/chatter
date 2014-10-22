package com.therapjavafest.chatter.service;

import com.therapjavafest.chatter.model.Chatter;

import java.util.List;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public interface ChatterService {
    public List<Chatter> getChatters();
}
