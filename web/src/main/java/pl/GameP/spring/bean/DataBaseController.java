package pl.GameP.spring.bean;

import org.springframework.stereotype.Repository;
import pl.GameP.spring.model.Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by elter on 12.03.17.
 */
@Repository
public class DataBaseController {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Account getAccountByID(String Login) {
        return entityManager.find(Account.class, Login);
    }

    @Transactional
    public GameProgress getGameProgressByID(int id) {
        return entityManager.find(GameProgress.class, id);
    }


    @Transactional
    public List<LevelSawmill> getListOfLevelSawmill() {
        Query query = entityManager.createQuery("SELECT l FROM LevelSawmill l");
        return query.getResultList();
    }

    @Transactional
    public List<LevelFarm> getListOfLevelFarm() {
        Query query = entityManager.createQuery("SELECT l FROM LevelFarm l");
        return query.getResultList();
    }

    @Transactional
    public List<LevelStonePit> getListOfLevelStonePit() {
        Query query = entityManager.createQuery("SELECT l FROM LevelStonePit l");
        return query.getResultList();
    }


    @Transactional
    public List<GameProgress> getAllGameProgress() {
        Query query = entityManager.createQuery("SELECT p FROM GameProgress p");
        return query.getResultList();
    }

    @Transactional
    public void saveData(Object object) {
        entityManager.merge(object);
    }


    public List<LevelVillage> getListOfLevelVillage() {
        Query query = entityManager.createQuery("SELECT v FROM LevelVillage v");
        return query.getResultList();
    }
}
