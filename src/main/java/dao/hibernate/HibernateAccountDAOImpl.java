package dao.hibernate;

import dao.AccountDAO;
import dao.util.HibernateUtil;
import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateAccountDAOImpl implements AccountDAO {
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction;
        List<Account> accounts = null;
        try {
            transaction = session.beginTransaction();
            accounts = session.createQuery("FROM Account ").list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error at getAll");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return accounts;
        }
    }
}