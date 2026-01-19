package com.revplay.auth;

public class User {

    private int userId;
    private String email;
    private String passwordHash;
    private String role;
    private String securityQuestion;
    private String securityAnswerHash;

    // Constructor for reading from DB
    public User(int userId, String email, String passwordHash,
                String role, String securityQuestion, String securityAnswerHash) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.securityQuestion = securityQuestion;
        this.securityAnswerHash = securityAnswerHash;
    }

    // Constructor for registration (before DB insert)
    public User(String email, String passwordHash,
                String role, String securityQuestion, String securityAnswerHash) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.securityQuestion = securityQuestion;
        this.securityAnswerHash = securityAnswerHash;
    }

    // ===== GETTERS =====
    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswerHash() {
        return securityAnswerHash;
    }
}
