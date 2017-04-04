package pl.GameP.spring.model;

import javax.persistence.*;

/**
 * Created by elter on 25.03.17.
 */
@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String loginaccount;
    private String role;

    public AccountRole() {
    }

    public AccountRole(String loginaccount, String role) {
        this.loginaccount = loginaccount;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
