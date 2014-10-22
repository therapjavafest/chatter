package com.therapjavafest.chatter.model;

import java.util.Date;

/**
 * @author Rony Gomes
 * @since 1.0
 */
public class Chatter {
    private int id;
    private String text;
    private Date created;
    private User createdBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
