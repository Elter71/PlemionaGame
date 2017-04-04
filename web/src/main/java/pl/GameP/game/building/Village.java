package pl.GameP.game.building;

import pl.GameP.spring.bean.GameBean;
import pl.GameP.spring.model.LevelVillage;

/**
 * Created by elter on 30.03.17.
 */
public class Village extends LevelVillage implements Building {
    private pl.GameP.game.Building NAME;

    public Village(LevelVillage village) {
        setLevel(village.getLevel());
        setValueFoodToExpansion(village.getValueFoodToExpansion());
        setValueStoneToExpansion(village.getValueStoneToExpansion());
        setValueWoodToExpansion(village.getValueWoodToExpansion());
        setTimeToExpansion(village.getTimeToExpansion());
        NAME = pl.GameP.game.Building.Wioska;
    }

    public void ExpansionBuilding() {
        LevelVillage levelVillage = GameBean.levelVillagesList.get(getLevel() + 1);
        setLevel(levelVillage.getLevel());
        setValueFoodToExpansion(levelVillage.getValueFoodToExpansion());
        setValueStoneToExpansion(levelVillage.getValueStoneToExpansion());
        setValueWoodToExpansion(levelVillage.getValueWoodToExpansion());
        setTimeToExpansion(levelVillage.getTimeToExpansion());
    }

    public pl.GameP.game.Building getNAME() {
        return NAME;
    }
}
