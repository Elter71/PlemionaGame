package pl.GameP.game.building;

import pl.GameP.spring.bean.GameBean;
import pl.GameP.spring.model.Entity.LevelFarm;

/**
 * Created by elter on 26.03.17.
 */
public class Farm extends LevelFarm implements Building {
    private pl.GameP.game.Building NAME;

    public Farm(LevelFarm farm) {
        setLevel(farm.getLevel());
        setValueFoodToExpansion(farm.getValueFoodToExpansion());
        setValueStoneToExpansion(farm.getValueStoneToExpansion());
        setValueWoodToExpansion(farm.getValueWoodToExpansion());
        setValueFoodPerHour(farm.getValueFoodPerHour());
        setTimeToExpansion(farm.getTimeToExpansion());
        NAME = pl.GameP.game.Building.Farma;
    }


    public void ExpansionBuilding() {
        LevelFarm levelFarm = GameBean.levelFarmList.get(getLevel() + 1);
        setLevel(levelFarm.getLevel());
        setValueFoodToExpansion(levelFarm.getValueFoodToExpansion());
        setValueStoneToExpansion(levelFarm.getValueStoneToExpansion());
        setValueWoodToExpansion(levelFarm.getValueWoodToExpansion());
        setValueFoodPerHour(levelFarm.getValueFoodPerHour());
        setTimeToExpansion(levelFarm.getTimeToExpansion());
    }

    public pl.GameP.game.Building getNAME() {
        return NAME;
    }
}
