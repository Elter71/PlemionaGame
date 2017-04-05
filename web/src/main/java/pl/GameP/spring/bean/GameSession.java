package pl.GameP.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by elter on 05.04.17.
 */
@Component
@Scope("session")
public class GameSession {
    private int ID = -1;

    public GameSession() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void removeSession(){

    }
}
