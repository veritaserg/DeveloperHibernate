package dao.hibernate;

import dao.AbstractDao;
import dao.AccountDAO;
import model.Account;

import java.util.List;

public class HibernateAccountDAOImpl extends AbstractDao<Account> implements AccountDAO {
    public HibernateAccountDAOImpl() {
        super.settClass(Account.class);
    }

    @Override
    public void create(Account account) {

    }

    @Override
    public Account getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Account> getAll() {
        return getAllAbstract();
    }
}