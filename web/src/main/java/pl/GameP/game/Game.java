package pl.GameP.game;

import pl.GameP.spring.bean.GameBean;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import pl.GameP.game.building.Building;

/**
 * Created by Rodzice on 09.03.2017.
 */

public class Game {

    private GameProgress gameProgress;


    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private GameRunnable runnable;
    private boolean isBulding;
    private Calendar timeNow;
    private Date timeToEndBulding;
    private pl.GameP.game.Building nowBulding;
    private String errorMessage;

    public Game(GameProgress gameProgress) {
        this.gameProgress = gameProgress;
        runnable = new GameRunnable(this);
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    public GameProgress getGameProgress() {
        return gameProgress;
    }

    public void buildingToNextLvL(pl.GameP.game.Building building) {
        errorMessage = "";

        switch (building) {
            case Tartak:
                if (!isBulding && getGameProgress().getSawmill().getLevel() < GameBean.levelSawmillList.size() - 1) {
                    if (this.MaterialsToExpansion(gameProgress.getSawmill())) {
                        timeNow = Calendar.getInstance();
                        timeToEndBulding = new Date(timeNow.getTimeInMillis() + getGameProgress().getSawmill().getTimeToExpansion() * 1000);
                        isBulding = true;
                        nowBulding = gameProgress.getSawmill().getNAME();
                    } else
                        errorMessage = "Za mało surowców.";
                } else {
                    if (isBulding)
                        errorMessage = "Już coś aktualnie budujesz.";
                    else
                        errorMessage = "Maksylany poziom budynku.";
                }
                break;
            case Farma:
                if (!isBulding && getGameProgress().getFarm().getLevel() < GameBean.levelFarmList.size() - 1) {
                    if (this.MaterialsToExpansion(gameProgress.getFarm())) {
                        timeNow = Calendar.getInstance();
                        timeToEndBulding = new Date(timeNow.getTimeInMillis() + getGameProgress().getFarm().getTimeToExpansion() * 1000);
                        isBulding = true;
                        nowBulding = gameProgress.getFarm().getNAME();
                    } else
                        errorMessage = "Za mało surowców.";
                } else {
                    if (isBulding)
                        errorMessage = "Już coś aktualnie budujesz.";
                    else
                        errorMessage = "Maksylany poziom budynku.";
                }
                break;
            case Kamieniołom:
                if (!isBulding && getGameProgress().getStonePit().getLevel() < GameBean.levelStonePitList.size() - 1) {
                    if (this.MaterialsToExpansion(gameProgress.getStonePit())) {
                        timeNow = Calendar.getInstance();
                        timeToEndBulding = new Date(timeNow.getTimeInMillis() + getGameProgress().getStonePit().getTimeToExpansion() * 1000);
                        isBulding = true;
                        nowBulding = gameProgress.getStonePit().getNAME();
                    } else
                        errorMessage = "Za mało surowców.";
                } else {
                    if (isBulding)
                        errorMessage = "Już coś aktualnie budujesz.";
                    else
                        errorMessage = "Maksylany poziom budynku.";
                }
                break;
            case Wioska:
                if (!isBulding && getGameProgress().getVillage().getLevel() < GameBean.levelVillagesList.size() - 1) {
                    if (this.MaterialsToExpansion(gameProgress.getVillage())) {
                        timeNow = Calendar.getInstance();
                        timeToEndBulding = new Date(timeNow.getTimeInMillis() + getGameProgress().getVillage().getTimeToExpansion() * 1000);
                        isBulding = true;
                        nowBulding = gameProgress.getVillage().getNAME();
                    } else
                        errorMessage = "Za mało surowców.";
                } else {
                    if (isBulding)
                        errorMessage = "Już coś aktualnie budujesz.";
                    else
                        errorMessage = "Maksylany poziom budynku.";
                }
                break;
        }

    }

    private boolean MaterialsToExpansion(Building building) {
        if (this.gameProgress.getAmountFood() < building.getValueFoodToExpansion()) {
            return false;
        }
        if (this.gameProgress.getAmountStone() < building.getValueStoneToExpansion()) {
            return false;
        }
        if (this.gameProgress.getAmountWood() < building.getValueWoodToExpansion()) {
            return false;
        }

        this.gameProgress.setAmountFood(this.gameProgress.getAmountFood() - building.getValueFoodToExpansion());
        this.gameProgress.setAmountStone(this.gameProgress.getAmountStone() - building.getValueStoneToExpansion());
        this.gameProgress.setAmountWood(this.gameProgress.getAmountWood() - building.getValueWoodToExpansion());

        return true;
    }

    public void stop() {
        scheduledExecutorService.shutdown();
    }

    public void refresh() {
        timeNow = Calendar.getInstance();
        try {
            if (timeToEndBulding.getTime() <= timeNow.getTimeInMillis() && isBulding) {

                switch (nowBulding) {
                    case Tartak:
                        gameProgress.getSawmill().ExpansionBuilding();
                        break;
                    case Kamieniołom:
                        gameProgress.getStonePit().ExpansionBuilding();
                        break;
                    case Farma:
                        gameProgress.getFarm().ExpansionBuilding();
                        break;
                    case Wioska:
                        gameProgress.getVillage().ExpansionBuilding();
                        gameProgress.getAccount().getGameProgress().add(new pl.GameP.spring.model.Entity.GameProgress(gameProgress.getIdAccount(), gameProgress.getAccount()));
                        System.out.println("GameProgressList Size" + gameProgress.getAccount().getGameProgress().size());
                        break;
                }
                isBulding = false;
                timeToEndBulding = null;
                nowBulding = null;
            }
        } catch (Exception e) {
        }
    }


    public Long TimeToEndBulding() {
        if (timeToEndBulding != null)
            return timeToEndBulding.getTime();

        return null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public pl.GameP.game.Building NowBulding() {
        return nowBulding;
    }
}
