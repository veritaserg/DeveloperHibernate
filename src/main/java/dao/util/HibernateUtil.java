package dao.util;


import model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.beans.Transient;
import java.util.List;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        List<Skill> skills = session.createQuery("FROM Skill ").list();
        for (Skill skill : skills){
            System.out.println(skill);
        }
        session.close();
    }
}
