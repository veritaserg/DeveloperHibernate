package dao.hibernate;

import dao.DeveloperDAO;
import dao.util.HibernateUtil;
import model.Developer;
import org.hibernate.Session;
import java.util.List;


public class HibernateDeveloperDAOImpl implements DeveloperDAO {

    @Override
    public void create(Developer developer) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
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

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            developer = (Developer) session.get(Developer.class, developerId);
            session.getTransaction().commit();
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

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
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
               try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Developer developer = (Developer) session.get(Developer.class, developerId);
            session.delete(developer);
            session.getTransaction().commit();
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