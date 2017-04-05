package pl.GameP.spring.model.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by elter on 26.03.17.
 */
@Entity
@Table(name = "levelStonePit")
public class LevelStonePit {
    @Id
    private int level;

    private int valueWoodToExpansion;
    private int valueStoneToExpansion;
    private int valueFoodToExpansion;
    private int valueStonePerHour;
    private int timeToExpansion;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getValueWoodToExpansion() {
        return valueWoodToExpansion;
    }

    public void setValueWoodToExpansion(int valueWoodToExpansion) {
        this.valueWoodToExpansion = valueWoodToExpansion;
    }

    public int getValueStoneToExpansion() {
        return valueStoneToExpansion;
    }

    public void setValueStoneToExpansion(int valueStoneToExpansion) {
        this.valueStoneToExpansion = valueStoneToExpansion;
    }

    public int getValueFoodToExpansion() {
        return valueFoodToExpansion;
    }

    public void setValueFoodToExpansion(int valueFoodToExpansion) {
        this.valueFoodToExpansion = valueFoodToExpansion;
    }

    public int getValueStonePerHour() {
        return valueStonePerHour;
    }

    public void setValueStonePerHour(int valueStonePerHour) {
        this.valueStonePerHour = valueStonePerHour;
    }

    public int getTimeToExpansion() {
        return timeToExpansion;
    }

    public void setTimeToExpansion(int timeToExpansion) {
        this.timeToExpansion = timeToExpansion;
    }
}
