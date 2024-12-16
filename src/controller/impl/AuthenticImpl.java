package controller.impl;

import java.sql.*;

import controller.Authentic;

import dao.*;
import model.Role;
import model.User;

public class AuthenticImpl implements Authentic {
	private UserDAO userDAO;

	public AuthenticImpl() {
		userDAO = new UserDAO();
	}

	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	@Override
	public boolean login(String username, String password, User user) throws SQLException {
		String sql = "SELECT role FROM USER where userName = ? and passWord = ?";
		ps = userDAO.connect().prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		if (rs.next()) {
			if (rs.getString("role").equalsIgnoreCase("ADMIN")) {
				user.setRole(Role.ADMIN);
			} else {
				user.setRole(Role.USER);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean logout() {
		return false;
	}

	@Override
	public boolean register() {
		return false;
	}
}
