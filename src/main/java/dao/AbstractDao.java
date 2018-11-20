package dao;

import dao.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDao<T> {
    private Class<T> tClass;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void createAbstract(T entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at create");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T getByIdAbstract(Long id) {
        T entity = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            entity = (T) session.get(tClass, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at getById ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return entity;
        }
    }


    public void updateAbstract(T entity) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at update ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteAbstract(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            T entity = (T) session.get(tClass, id);
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at delete ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> getAllAbstract() {
        Session session = sessionFactory.openSession();
        List<T> entity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            entity = session.createQuery("FROM " + tClass.getName()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error at getAll ");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return entity;
        }
    }
}
