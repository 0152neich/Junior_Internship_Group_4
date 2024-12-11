package controller;

import java.sql.SQLException;

import model.User;

public interface Authentic {

    public boolean login(String username, String password, User user) throws SQLException ;
    public boolean logout() ;
    public boolean register() ;

}
