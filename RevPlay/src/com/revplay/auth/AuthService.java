package com.revplay.auth;

public class AuthService {

    private UserDao userDao = new UserDao();

    // REGISTER
    public void register(String email, String password, String role,
                         String question, String answer) {

        try {
            if (userDao.findByEmail(email) != null) {
                System.out.println("User already exists");
                return;
            }

            User user = new User(
                    email,
                    PasswordUtil.hash(password),
                    role,
                    question,
                    PasswordUtil.hash(answer)
            );

            userDao.register(user);
            System.out.println("Registration successful");

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Registration failed");
        }
    }

    // LOGIN
    public User login(String email, String password) {

        try {
            User user = userDao.findByEmail(email);

            if (user == null) {
                System.out.println("User not found");
                return null;
            }

            if (!PasswordUtil.hash(password).equals(user.getPasswordHash())) {
                System.out.println("Invalid password");
                return null;
            }

            System.out.println("Login successful");
            return user;

        } catch (Exception e) {
            System.out.println("Login error");
            return null;
        }
    }

    // CHANGE PASSWORD
    public void changePassword(int userId, String newPassword) {
        try {
            userDao.updatePassword(userId, PasswordUtil.hash(newPassword));
            System.out.println("Password updated");
        } catch (Exception e) {
            System.out.println("Password update failed");
        }
    }

    // FORGOT PASSWORD
    public void forgotPassword(String email, String answer, String newPassword) {
        try {
            User user = userDao.findByEmail(email);

            if (user == null) {
                System.out.println("User not found");
                return;
            }

            if (!PasswordUtil.hash(answer).equals(user.getSecurityAnswerHash())) {
                System.out.println("Security answer incorrect");
                return;
            }

            userDao.updatePassword(user.getUserId(),
                    PasswordUtil.hash(newPassword));
            System.out.println("Password reset successful");

        } catch (Exception e) {
            System.out.println("Password reset failed");
        }
    }
}
