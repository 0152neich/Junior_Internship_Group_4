package controller;

import model.User;
public interface Authentic {
    public boolean login() ;
    public boolean logout() ;
    public boolean register(User u) ;

}
