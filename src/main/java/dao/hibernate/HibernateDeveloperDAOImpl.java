package dao.hibernate;
import dao.DeveloperDAO;
import dao.util.HibernateUtil;
import model.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class HibernateDeveloperDAOImpl implements DeveloperDAO {

    @Override
    public void create(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Ошибка при вставке");
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public Developer getById(Long developerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        return developer;
    }

    @Override
    public void update(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
               session.update(developer);
        transaction.commit();
        session.close();

    }

    @Override
    public void delete(Long developerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }

    public List<Developer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer ").list();
        transaction.commit();
        session.close();
        return developers;
    }
}