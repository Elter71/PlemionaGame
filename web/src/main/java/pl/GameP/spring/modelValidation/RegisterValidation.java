package pl.GameP.spring.modelValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import pl.GameP.spring.bean.RegisterService;
import pl.GameP.spring.model.AccountData;

/**
 * Created by elter on 05.04.17.
 */
@Component
public class RegisterValidation {
    @Autowired
    private RegisterService registerService;
    private BindingResult result;
    private AccountData account;


    public void setResult(BindingResult result) {
        this.result = result;
    }

    public void sendAccount(AccountData account) {
        this.account = account;
        if (!account.passwordIsTheSame())
            passowrdErrorMessage("Hasła nie są identyczne.");
        if (registerService.isAccountExist(account))
            accountExistErrorMessage("Login jest już zajęty.");
    }

    private void passowrdErrorMessage(String message) {
        result.rejectValue("password", "error.password", message);
    }

    private void accountExistErrorMessage(String message) {
        result.rejectValue("login", "error.login", message);
    }

    public ModelAndView getModelAndView() {
        if (result.hasErrors())
            return new ModelAndView("register");
        else {
            registerService.saveDataInDataBase(account);
            return new ModelAndView("index");
        }
    }
}
