package pl.GameP.spring.model.Entity;

import pl.GameP.spring.bean.GameBean;

import javax.persistence.*;

/**
 * Created by elter on 12.03.17.
 */
@Entity
@Table(name = "gameprogress")
public class GameProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdProgress;
    @Column(insertable = false, updatable = false)
    private String IdAccount;

    private int amountWood;
    private int amountStone;
    private int amountFood;
    @Column(insertable = false, updatable = false)
    private int levelSawmill;
    @Column(insertable = false, updatable = false)
    private int levelStonePit;
    @Column(insertable = false, updatable = false)
    private int levelFarm;
    private int timeToGetMaterials;


    @ManyToOne()
    @JoinColumn(name = "levelSawmill")
    private LevelSawmill LevelSawmill;

    @ManyToOne()
    @JoinColumn(name = "levelFarm")
    private LevelFarm LevelFarm;

    @ManyToOne()
    @JoinColumn(name = "levelStonePit")
    private LevelStonePit LevelStonePit;

    @ManyToOne()
    @JoinColumn(name = "IdAccount")
    private Account account;

    public GameProgress() {
    }

    public GameProgress(String idAccount, Account account) {
        IdAccount = idAccount;
        this.account = account;
        amountWood = 300;
        amountStone = 300;
        amountFood = 300;
        levelSawmill = 0;
        timeToGetMaterials = 3600;
        LevelSawmill = GameBean.levelSawmillList.get(levelSawmill);

        levelFarm = 0;
        LevelFarm = GameBean.levelFarmList.get(levelFarm);
        levelStonePit = 0;
        LevelStonePit = GameBean.levelStonePitList.get(levelStonePit);

    }

    public int getIdProgress() {
        return IdProgress;
    }

    public void setIdProgress(int idProgress) {
        IdProgress = idProgress;
    }

    public String getIdAccount() {
        return IdAccount;
    }

    public void setIdAccount(String idAccount) {
        IdAccount = idAccount;
    }

    public int getAmountWood() {
        return amountWood;
    }

    public void setAmountWood(int amountWood) {
        this.amountWood = amountWood;
    }

    public int getAmountStone() {
        return amountStone;
    }

    public void setAmountStone(int amountStone) {
        this.amountStone = amountStone;
    }

    public int getAmountFood() {
        return amountFood;
    }

    public void setAmountFood(int amountFood) {
        this.amountFood = amountFood;
    }

    public int getLevelSawmill() {
        return levelSawmill;
    }

    public void setLevelSawmill(int levelSawmill) {
        this.levelSawmill = levelSawmill;
    }

    public int getTimeToGetMaterials() {
        return timeToGetMaterials;
    }

    public void setTimeToGetMaterials(int timeToGetMaterials) {
        this.timeToGetMaterials = timeToGetMaterials;
    }

    public LevelSawmill getSawmillBulding() {
        return LevelSawmill;
    }

    public void setSawmillBulding(LevelSawmill levelSawmill) {
        this.LevelSawmill = levelSawmill;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getLevelFarm() {
        return levelFarm;
    }

    public void setLevelFarm(int levelFarm) {
        this.levelFarm = levelFarm;
    }

    public LevelFarm getFarmBulding() {
        return LevelFarm;
    }

    public void setFarmBulding(LevelFarm levelFarm) {
        this.LevelFarm = levelFarm;
    }

    public int getLevelStonePit() {
        return levelStonePit;
    }

    public void setLevelStonePit(int levelStonePit) {
        this.levelStonePit = levelStonePit;
    }

    public LevelStonePit getStonePitBulding() {
        return LevelStonePit;
    }

    public void setStonePitBulding(LevelStonePit levelStonePit) {
        this.LevelStonePit = levelStonePit;
    }
}
