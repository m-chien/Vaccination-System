package phantichtkhdt.tiemchung.Account;

import phantichtkhdt.tiemchung.Role;

public class UserAccount {
    private static int idCounter =1;
    private int Id;
    private String username;
    private String password;
    private Role role;

    public UserAccount(String username, String password, Role role) {
        this.Id = idCounter++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}'+"\n";
    }
}
