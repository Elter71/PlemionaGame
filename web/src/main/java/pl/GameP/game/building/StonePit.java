package pl.GameP.game.building;

import pl.GameP.spring.bean.GameBean;
import pl.GameP.spring.model.LevelStonePit;

/**
 * Created by elter on 26.03.17.
 */
public class StonePit extends LevelStonePit implements Building {
    private pl.GameP.game.Building NAME;

    public StonePit(LevelStonePit stonePit) {
        setLevel(stonePit.getLevel());
        setValueFoodToExpansion(stonePit.getValueFoodToExpansion());
        setValueStoneToExpansion(stonePit.getValueStoneToExpansion());
        setValueWoodToExpansion(stonePit.getValueWoodToExpansion());
        setValueStonePerHour(stonePit.getValueStonePerHour());
        setTimeToExpansion(stonePit.getTimeToExpansion());
        NAME = pl.GameP.game.Building.Kamieniołom;
    }

    public void ExpansionBuilding() {
        LevelStonePit levelSawmill = GameBean.levelStonePitList.get(getLevel() + 1);
        setLevel(levelSawmill.getLevel());
        setValueFoodToExpansion(levelSawmill.getValueFoodToExpansion());
        setValueStoneToExpansion(levelSawmill.getValueStoneToExpansion());
        setValueWoodToExpansion(levelSawmill.getValueWoodToExpansion());
        setValueStonePerHour(levelSawmill.getValueStonePerHour());
        setTimeToExpansion(levelSawmill.getTimeToExpansion());
    }

    public pl.GameP.game.Building getNAME() {
        return NAME;
    }
}
