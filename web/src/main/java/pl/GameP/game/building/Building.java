package pl.GameP.game.building;

/**
 * Created by elter on 26.03.17.
 */
public interface Building {
    public int getValueFoodToExpansion();

    public int getValueStoneToExpansion();

    public int getValueWoodToExpansion();

    public void ExpansionBuilding();

    public pl.GameP.game.Building getNAME();
}
