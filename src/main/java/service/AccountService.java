package service;

import dao.hibernate.HibernateAccountDAOImpl;
import model.Account;
import java.util.List;

public class AccountService {
  HibernateAccountDAOImpl hibernateAccountDAO;
    public AccountService(){
        hibernateAccountDAO = new HibernateAccountDAOImpl();
    }
    public void create(Account account) {
        hibernateAccountDAO.create(account);
    }

    public Account getById(Long id) {
        return hibernateAccountDAO.getById(id);
    }

    public void update(Account account) {
        hibernateAccountDAO.update(account);
    }

    public void delete(Long id) {
        hibernateAccountDAO.delete(id);
    }

    public List<Account> getAll() {
        return hibernateAccountDAO.getAll();
    }
}
