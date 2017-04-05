package pl.GameP.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.GameP.spring.model.AccountData;
import pl.GameP.spring.bean.RegisterService;
import pl.GameP.spring.modelValidation.LoginValidation;
import pl.GameP.spring.modelValidation.RegisterValidation;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by elter on 09.03.2017.
 */
@Controller
public class MainController {

    @Autowired
    private RegisterValidation registerValidation;
    @Autowired
    private LoginValidation loginValidation;

    @RequestMapping("/")
    public ModelAndView intexWeb() {
        return new ModelAndView("index");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        loginValidation.sendError(error);
        loginValidation.sendLogout(logout);
        return loginValidation.getModelAndView();

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register", "registerForm", new AccountData());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("registerForm") @Valid AccountData account, BindingResult result) {
        registerValidation.setResult(result);
        registerValidation.sendAccount(account);
        return this.registerValidation.getModelAndView();
    }


}
