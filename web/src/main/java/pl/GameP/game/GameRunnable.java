package pl.GameP.game;

/**
 * Created by elter on 10.03.17.
 */
public class GameRunnable implements Runnable {

    private Game game;

    public GameRunnable(Game game) {
        this.game = game;
    }

    public void run() {
        if (reduceTimeToGetMaterials() <= 0) {
            addFood();
            addStone();
            addWood();
        }
        game.refresh();
    }

    private int reduceTimeToGetMaterials() {
        int TimeToGetMaterials = game.getGameProgress().getTimeToGetMaterials();
        TimeToGetMaterials--;
        game.getGameProgress().setTimeToGetMaterials(TimeToGetMaterials);
        return TimeToGetMaterials;
    }

    private void addWood() {
        game.getGameProgress().setAmountWood(game.getGameProgress().getAmountWood()
                + game.getGameProgress().getSawmill().getValueWoodPerHour());
        game.getGameProgress().setTimeToGetMaterials(3600); // 1 godzina w s
        System.out.println("Add Wood");
    }

    private void addStone() {
        game.getGameProgress().setAmountStone(game.getGameProgress().getAmountStone()
                + game.getGameProgress().getStonePit().getValueStonePerHour());
        game.getGameProgress().setTimeToGetMaterials(3600); // 1 godzina w s
        System.out.println("Add Stone");

    }

    private void addFood() {
        game.getGameProgress().setAmountFood(game.getGameProgress().getAmountFood()
                + game.getGameProgress().getFarm().getValueFoodPerHour());
        game.getGameProgress().setTimeToGetMaterials(3600); // 1 godzina w s
        System.out.println("Add Food");

    }
}
