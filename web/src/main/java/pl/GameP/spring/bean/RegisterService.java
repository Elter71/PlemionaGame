package pl.GameP.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.GameP.data.AccountData;
import pl.GameP.spring.model.AccountRole;
import pl.GameP.spring.model.GameProgress;
import pl.GameP.spring.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elter on 25.03.17.
 */
@Service
public class RegisterService {

    @Autowired
    private DataBaseController dataBaseController;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public boolean isAccountExist(AccountData accountData) {
        if (dataBaseController.getAccountByID(accountData.getLogin()) != null)
            return true;
        return false;
    }

    public void saveDataInDataBase(AccountData accountData) {
        Account account = new Account(accountData.getLogin(),accountData.getPassword(),true);
        account.setLogin(accountData.getLogin());
        account.setPassword(bCryptPasswordEncoder.encode(accountData.getPassword()));
        account.setEnabled(true);
        List<GameProgress> list = new ArrayList<GameProgress>();
        list.add(new GameProgress(account.getLogin(), account));
        account.setGameProgress(list);
        dataBaseController.saveData(account);

        dataBaseController.saveData(new AccountRole(account.getLogin(), "ROLE_USER"));

    }

}
