package pl.GameP.spring.model;


import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * Created by Elter on 23.03.2017.
 */
public class AccountData {
    @Size(min = 3, message = "Login musi być większy niż 3 znaki.")
    private String login;
    @Size(min = 8, message = "Hasło musi być większy niż 8 znaki.")
    private String password;
    private String samePassword;
    @AssertTrue(message = "Musi akceptować regulamin.")
    private boolean accept = true;

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

    public String getSamePassword() {
        return samePassword;
    }

    public void setSamePassword(String samePassword) {
        this.samePassword = samePassword;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean passwordIsTheSame() {
        return password.equals(samePassword);
    }
}
