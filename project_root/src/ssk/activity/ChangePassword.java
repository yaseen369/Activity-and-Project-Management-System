package ssk.activity;

import ssk.activity.model.User;

public class ChangePassword {

    public boolean changeUserPassword(User user, String oldPassword, String newPassword) {
        if (user == null) {
            System.out.println("Error: User object is null.");
            return false;
        }

        if (oldPassword == null || oldPassword.trim().isEmpty() || newPassword == null || newPassword.trim().isEmpty()) {
            System.out.println("Old password and new password cannot be empty.");
            return false;
        }

        if (user.verifyPassword(oldPassword)) {
            user.setPassword(newPassword);
            System.out.println("Password changed successfully for user: " + user.getUsername());
            return true;
        } else {
            System.out.println("Failed to change password. The old password did not match for user: " + user.getUsername());
            return false;
        }
    }
}
