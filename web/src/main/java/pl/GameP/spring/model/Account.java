package pl.GameP.spring.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by elter on 12.03.17.
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    private String login;
    private String password;

    @Column(nullable = false, columnDefinition = "TINYINT(0)")
    private boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.EAGER)
    private List<GameProgress> gameProgress;

    public Account() {
    }

    public Account(String login, String password, boolean enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GameProgress> getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(List<GameProgress> gameProgress) {
        this.gameProgress = gameProgress;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
