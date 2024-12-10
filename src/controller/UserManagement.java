package controller;

import model.User;

public interface UserManagement {
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(String id);
    public boolean showUser();
    boolean checkEmailExists(String email);
    boolean checkUsernameExists(String username);
}
