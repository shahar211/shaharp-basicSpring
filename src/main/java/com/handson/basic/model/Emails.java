package com.handson.basic.model;

public class Emails {
    String message;
    String email;

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public Emails(String message, String email) {
        this.message = message;
        this.email = email;
    }
}
