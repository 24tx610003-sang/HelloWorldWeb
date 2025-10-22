package hello.com.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "UserJPA")
@NamedQuery(name = "UserJPA.findAll", query = "SELECT u FROM UserJPA u")
public class UserJPA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String fullname;

    @Column(nullable = false)
    private int roleid; // 1 = admin, 2 = manager, 3 = user

    public UserJPA() {
    }

    public UserJPA(String username, String password, String fullname, int roleid) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.roleid = roleid;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
