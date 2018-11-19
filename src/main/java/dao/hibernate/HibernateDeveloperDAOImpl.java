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
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error at create");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Developer getById(Long developerId) {
        Developer developer = null;
        Session session = null;
        Transaction transaction;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            developer = (Developer) session.get(Developer.class, developerId);
        } catch (Exception e) {
            System.out.println("error at getById ");
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return developer;
        }
    }

    @Override
    public void update(Developer developer) {
        Session session = null;
        Transaction transaction;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(developer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error at update ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long developerId) {
        Session session = null;
        Transaction transaction;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Developer developer = (Developer) session.get(Developer.class, developerId);
            session.delete(developer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error at delete ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Developer> getAll() {
        Session session = null;
        List<Developer> developers = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            developers = session.createQuery("FROM Developer ").list();
          session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at getAll ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return developers;
        }
    }
}