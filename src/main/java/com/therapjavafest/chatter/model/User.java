package com.therapjavafest.chatter.model;

import java.io.Serializable;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 10/21/14.
 */
public class User implements Serializable{
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String passwordConfirmed;

    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String password, String passwordConfirmed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.passwordConfirmed = passwordConfirmed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    @Override
    public String toString() {

        return firstName + " " + lastName;
    }
}
