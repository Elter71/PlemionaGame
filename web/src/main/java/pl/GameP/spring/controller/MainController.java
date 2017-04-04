package pl.GameP.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.GameP.data.AccountData;
import pl.GameP.spring.bean.RegisterService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodzice on 09.03.2017.
 */
@Controller
public class MainController {

    @Autowired
    RegisterService registerService;

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
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Nieprawidłowy login lub hasło!");
        }

        if (logout != null) {
            modelAndView.addObject("msg", "Wylogowałeś się pomyślnie");

        }
        modelAndView.setViewName("login");
        return modelAndView;

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register", "registerForm", new AccountData());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("registerForm") @Valid AccountData account, BindingResult result) {
        if (!account.getPassword().equals(account.getSamePassword()))
            result.rejectValue("password", "error.password", "Hasła nie są identyczne.");
        if (registerService.isAccountExist(account))
            result.rejectValue("login", "error.login", "Login jest już zajęty.");

        if (result.hasErrors()) {
            return new ModelAndView("register");
        } else {
            registerService.saveDataInDataBase(account);
            return new ModelAndView("index");
        }

    }


}
