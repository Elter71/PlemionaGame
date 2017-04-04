package pl.GameP.game.building;

import pl.GameP.spring.bean.GameBean;
import pl.GameP.spring.model.LevelSawmill;

/**
 * Created by Rodzice on 09.03.2017.
 */
public class Sawmill extends LevelSawmill implements Building {

    private pl.GameP.game.Building NAME;

    public Sawmill(LevelSawmill sawmill) {
        setLevel(sawmill.getLevel());
        setValueFoodToExpansion(sawmill.getValueFoodToExpansion());
        setValueStoneToExpansion(sawmill.getValueStoneToExpansion());
        setValueWoodToExpansion(sawmill.getValueWoodToExpansion());
        setValueWoodPerHour(sawmill.getValueWoodPerHour());
        setTimeToExpansion(sawmill.getTimeToExpansion());
        NAME = pl.GameP.game.Building.Tartak;
    }

    public void ExpansionBuilding() {
        LevelSawmill levelSawmill = GameBean.levelSawmillList.get(getLevel() + 1);
        setLevel(levelSawmill.getLevel());
        setValueFoodToExpansion(levelSawmill.getValueFoodToExpansion());
        setValueStoneToExpansion(levelSawmill.getValueStoneToExpansion());
        setValueWoodToExpansion(levelSawmill.getValueWoodToExpansion());
        setValueWoodPerHour(levelSawmill.getValueWoodPerHour());
        setTimeToExpansion(levelSawmill.getTimeToExpansion());

    }

    public pl.GameP.game.Building getNAME() {
        return NAME;
    }
}
