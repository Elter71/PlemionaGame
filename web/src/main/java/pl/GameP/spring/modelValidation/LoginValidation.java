package pl.GameP.spring.modelValidation;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by elter on 05.04.17.
 */
@Component
public class LoginValidation {
    private ModelAndView modelAndView;

    public LoginValidation() {
        this.modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
    }

    public void sendError(String action) {
        if (action != null)
            errorMessage("Nieprawidłowy login lub hasło!");
    }

    public void sendLogout(String action) {
        if (action != null)
            logoutMessage("Wylogowałeś się pomyślnie");
    }

    private void errorMessage(String message) {
        modelAndView.addObject("error", message);
    }

    private void logoutMessage(String message) {
        modelAndView.addObject("msg", message);
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }
}
