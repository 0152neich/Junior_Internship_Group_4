package controller.impl;

import controller.Authentic;
import model.User;

public class AuthenticImpl implements Authentic {
    @Override
    public boolean login(){
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean register(User u) {
        return false;
    }
}
