package pl.GameP.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.GameP.spring.bean.GameBean;
import pl.GameP.game.Building;
import pl.GameP.game.Game;
import pl.GameP.spring.model.Account;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elter on 09.03.2017.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameBean gameBean;

    private String message;


    @PostConstruct
    public void initServer() {
        gameBean.setLists();
        gameBean.createGameFromAccounInDataBase();
    }

    @RequestMapping("/admin/reset")
    public String resetGames() {
        gameBean.resetData();
        return "index";
    }

    @RequestMapping("/menu")
    public ModelAndView menuGame(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        session.removeAttribute("ID");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("ID -menu-" + session.getAttribute("ID"));
        modelAndView.addObject("GameProgressList", this.gameBean.getAccountByLogin(authentication.getName()).getGameProgress());
        modelAndView.setViewName("GameIndex");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexGame(HttpSession session, ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (session.getAttribute("ID") != null) {
            int id = (Integer) session.getAttribute("ID");
            setValueToModelMap(modelMap, gameBean.getGameByID(id));
            gameBean.getGameByID(id).refresh();
            System.out.println("Refresh accoutn gameprogress list" + gameBean.getGameByID(id).getGameProgress().getAccount().getGameProgress().size());
            int size = gameBean.getGameByID(id).getGameProgress().getAccount().getGameProgress().size();
            gameBean.saveAccount(gameBean.getGameByID(id).getGameProgress().getAccount().getGameProgress().get(size - 1));
//            System.out.println("Refresh GameProgress Size" + this.gameBean.getAccountByLogin(authentication.getName()));
            return new ModelAndView("Game");
        }

        modelMap.addAttribute("GameProgressList", this.gameBean.getAccountByLogin(authentication.getName()).getGameProgress());

        return new ModelAndView("GameIndex");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String startGameByID(@RequestParam String action, HttpSession session, ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        resetVarable();
        Account account = gameBean.getAccountByLogin(authentication.getName());
        int i = Integer.parseInt(action);
        session.setAttribute("ID", account.getGameProgress().get(i-1).getIdProgress());
        System.out.println("Action!!" + action + "|||" + session.getAttribute("ID"));

        setValueToModelMap(modelMap, gameBean.getGameByID((Integer) session.getAttribute("ID")));
        return "Game";
    }

    @RequestMapping("/{action}")
    public ModelAndView BuildingSawmill(HttpSession session, @PathVariable("action") int action) {
        resetVarable();
        if (session.getAttribute("ID") == null)
            return new ModelAndView("redirect:" + "/game/");
        Game game = gameBean.getGameByID((Integer) session.getAttribute("ID"));
        switch (action) {
            case 1:
                game.buildingToNextLvL(Building.Tartak);
                if (!game.getErrorMessage().equals(""))
                    message = game.getErrorMessage();
                else
                    message = "Budowanie tartaku.";
                break;
            case 2:
                gameBean.getGameByID((Integer) session.getAttribute("ID")).buildingToNextLvL(Building.Farma);
                if (!game.getErrorMessage().equals(""))
                    message = game.getErrorMessage();
                else
                    message = "Budowanie farmy.";
                break;
            case 3:
                gameBean.getGameByID((Integer) session.getAttribute("ID")).buildingToNextLvL(Building.Kamieniołom);
                if (!game.getErrorMessage().equals(""))
                    message = game.getErrorMessage();
                else
                    message = "Budowanie kamieniołom.";
                break;
            case 99:
                game.buildingToNextLvL(Building.Wioska);
                if (!game.getErrorMessage().equals(""))
                    message = game.getErrorMessage();
                else
                    message = "Budowanie wioske.";
        }
        return new ModelAndView("redirect:" + "/game/");
    }

    private void setValueToModelMap(ModelMap modelMap, Game game) {
        List<Integer> amount = new ArrayList<Integer>();
        amount.add(game.getGameProgress().getAmountWood());
        amount.add(game.getGameProgress().getAmountStone());
        amount.add(game.getGameProgress().getAmountFood());

        List<Integer> SawmillList = new ArrayList<Integer>();
        SawmillList.add(game.getGameProgress().getSawmill().getLevel());
        SawmillList.add(game.getGameProgress().getSawmill().getValueWoodToExpansion());
        SawmillList.add(game.getGameProgress().getSawmill().getValueStoneToExpansion());
        SawmillList.add(game.getGameProgress().getSawmill().getValueFoodToExpansion());
        SawmillList.add(game.getGameProgress().getSawmill().getTimeToExpansion());

        List<Integer> FarmList = new ArrayList<Integer>();
        FarmList.add(game.getGameProgress().getFarm().getLevel());
        FarmList.add(game.getGameProgress().getFarm().getValueWoodToExpansion());
        FarmList.add(game.getGameProgress().getFarm().getValueStoneToExpansion());
        FarmList.add(game.getGameProgress().getFarm().getValueFoodToExpansion());
        FarmList.add(game.getGameProgress().getFarm().getTimeToExpansion());

        List<Integer> StonePitList = new ArrayList<Integer>();
        StonePitList.add(game.getGameProgress().getStonePit().getLevel());
        StonePitList.add(game.getGameProgress().getStonePit().getValueWoodToExpansion());
        StonePitList.add(game.getGameProgress().getStonePit().getValueStoneToExpansion());
        StonePitList.add(game.getGameProgress().getStonePit().getValueFoodToExpansion());
        StonePitList.add(game.getGameProgress().getStonePit().getTimeToExpansion());

        List<Integer> VillageList = new ArrayList<Integer>();
        VillageList.add(game.getGameProgress().getVillage().getLevel());
        VillageList.add(game.getGameProgress().getVillage().getValueWoodToExpansion());
        VillageList.add(game.getGameProgress().getVillage().getValueStoneToExpansion());
        VillageList.add(game.getGameProgress().getVillage().getValueFoodToExpansion());
        VillageList.add(game.getGameProgress().getVillage().getTimeToExpansion());

        List<Integer> MaterialsPerHours = new ArrayList<Integer>();
        MaterialsPerHours.add(game.getGameProgress().getSawmill().getValueWoodPerHour());
        MaterialsPerHours.add(game.getGameProgress().getFarm().getValueFoodPerHour());
        MaterialsPerHours.add(game.getGameProgress().getStonePit().getValueStonePerHour());


        List<String> GameInformation = new ArrayList<String>();
        GameInformation.add(game.TimeToEndBulding() + "");
        GameInformation.add(game.NowBulding() + "");

        modelMap.addAttribute("amount", amount);
        modelMap.addAttribute("SawmillList", SawmillList);
        modelMap.addAttribute("MaterialsPerHours", MaterialsPerHours);
        modelMap.addAttribute("GameInformation", GameInformation);
        modelMap.addAttribute("FarmList", FarmList);
        modelMap.addAttribute("StonePitList", StonePitList);
        modelMap.addAttribute("Village", VillageList);
        modelMap.addAttribute("message", message);

//        modelMap.addAttribute("GameProgressList",game.getGameProgress().getAccount().getGameProgress());

    }

    @PreDestroy
    public void stopServer() {
        gameBean.stopServer();
        System.out.println("Stop server!!!");
    }

    private void resetVarable() {
        message = "";
    }
}
