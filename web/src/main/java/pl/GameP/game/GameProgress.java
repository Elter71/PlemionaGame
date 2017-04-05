package pl.GameP.game;

import pl.GameP.game.building.*;
import pl.GameP.spring.bean.GameBean;

/**
 * Created by Rodzice on 09.03.2017.
 */
public class GameProgress extends pl.GameP.spring.model.Entity.GameProgress {
    private Sawmill sawmill;
    private Farm farm;
    private StonePit stonePit;
    private Village village;

    public GameProgress(pl.GameP.spring.model.Entity.GameProgress gameProgress) {

        this.setIdProgress(gameProgress.getIdProgress());
        this.setIdAccount(gameProgress.getIdAccount());
        this.setAccount(gameProgress.getAccount());
        this.setAmountWood(gameProgress.getAmountWood());
        this.setAmountStone(gameProgress.getAmountStone());
        this.setAmountFood(gameProgress.getAmountFood());
        this.setTimeToGetMaterials(gameProgress.getTimeToGetMaterials());
        this.setLevelSawmill(gameProgress.getLevelSawmill());
        this.setSawmillBulding(gameProgress.getSawmillBulding());

        this.farm = new Farm(gameProgress.getFarmBulding());
        this.stonePit = new StonePit(gameProgress.getStonePitBulding());
        this.sawmill = new Sawmill(gameProgress.getSawmillBulding());
        this.village = new Village(GameBean.levelVillagesList.get(gameProgress.getAccount().getGameProgress().size()));
    }

    public Sawmill getSawmill() {
        return sawmill;
    }

    public Farm getFarm() {
        return farm;
    }

    public StonePit getStonePit() {
        return stonePit;
    }
    public Village getVillage(){
        return village;
    }
    public pl.GameP.spring.model.Entity.GameProgress toModel() {
        pl.GameP.spring.model.Entity.GameProgress progressModel = new pl.GameP.spring.model.Entity.GameProgress();
        progressModel.setIdProgress(this.getIdProgress());
        progressModel.setIdAccount(this.getIdAccount());
        progressModel.setAccount(this.getAccount());
        progressModel.setAmountWood(this.getAmountWood());
        progressModel.setAmountStone(this.getAmountStone());
        progressModel.setAmountFood(this.getAmountFood());
        progressModel.setTimeToGetMaterials(this.getTimeToGetMaterials());
        progressModel.setLevelFarm(this.farm.getLevel());
        progressModel.setFarmBulding(GameBean.levelFarmList.get(this.farm.getLevel()));
        progressModel.setLevelStonePit(this.stonePit.getLevel());
        progressModel.setStonePitBulding(GameBean.levelStonePitList.get(this.stonePit.getLevel()));
        progressModel.setLevelSawmill(this.sawmill.getLevel());
        progressModel.setSawmillBulding(GameBean.levelSawmillList.get(this.sawmill.getLevel()));
        return progressModel;
    }


}
