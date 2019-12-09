package com.example.hex;

public class User {
    String userId;
    String profileType;
    String userEmail;
    String username;
    String phoneNumber;
    Integer noOfEvents;
    Integer noStars;
    Integer noOfFriends;

    public User(){ }

    public User(String userId, String userEmail, String username) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUsername() {
        return username;
    }
}
