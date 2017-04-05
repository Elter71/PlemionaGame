package pl.GameP.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.GameP.game.Game;
import pl.GameP.game.GameProgress;
import pl.GameP.spring.model.Entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elter on 11.03.17.
 */
@Service
public class GameBean {

    private List<Game> gameList;

    static public List<LevelSawmill> levelSawmillList;
    static public List<LevelFarm> levelFarmList;
    static public List<LevelStonePit> levelStonePitList;
    static public List<LevelVillage> levelVillagesList;


    @Autowired
    DataBaseController dataBaseController;


    public GameBean() {
        gameList = new ArrayList<Game>();

    }

    public Account getAccountByLogin(String Login) {
        return dataBaseController.getAccountByID(Login);
    }

    public Game getGameByID(int id) {

        for (Game game :
                gameList) {
            if (game.getGameProgress().getIdProgress() == id)
                return game;
        }
        Game game = createGameByID(id);
        gameList.add(game);
        return game;
    }

    private Game createGameByID(int id) {
        return new Game(new GameProgress(dataBaseController.getGameProgressByID(id)));
    }

    public void createGameFromAccounInDataBase() {
        List<pl.GameP.spring.model.Entity.GameProgress> progresses = dataBaseController.getAllGameProgress();

        boolean isBreak;
        for (pl.GameP.spring.model.Entity.GameProgress gameProgress :
                progresses) {
            isBreak = false;
            for (Game game :
                    gameList) {
                if (game.getGameProgress().getIdProgress() == gameProgress.getIdProgress()) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak)
                continue;
            System.out.println("Create Account!!");
            gameList.add(new Game(new GameProgress(gameProgress)));
            System.out.println("GAME LIST SIZE!!" + gameList.size());
        }
    }

    public void stopServer() {
        System.out.println("GameList: " + gameList.size());
        for (Game game :
                gameList) {
            System.out.println("Stop game " + game.getGameProgress().getIdProgress() + " ||| " + game.getGameProgress().getSawmill().getLevel());
            dataBaseController.saveData(game.getGameProgress().toModel());
            game.stop();
        }
    }

    public void setLists() {
        levelSawmillList = dataBaseController.getListOfLevelSawmill();
        levelStonePitList = dataBaseController.getListOfLevelStonePit();
        levelFarmList = dataBaseController.getListOfLevelFarm();
        levelVillagesList = dataBaseController.getListOfLevelVillage();
    }

    public void resetData() {
        this.gameList = new ArrayList<Game>();
        setLists();
    }

    public void saveAccount(pl.GameP.spring.model.Entity.GameProgress gameProgress) {
        dataBaseController.saveData(gameProgress);
    }
}
