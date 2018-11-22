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
createAbstract(account);
    }

    @Override
    public Account getById(Long id) {
        return getByIdAbstract(id);
    }

    @Override
    public void update(Account account) {
updateAbstract(account);
    }

    @Override
    public void delete(Long id) {
deleteAbstract(id);
    }

    @Override
    public List<Account> getAll() {
        return getAllAbstract();
    }
}