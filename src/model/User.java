package model;

public class User {
    private String id; // ID kiểu String
    private String fullname;
    private String email;
    private String username;
    private String password;
    private String phone;
    private Role role;

    public User(String fullname, String email, String username, String password, String phone, Role role) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
