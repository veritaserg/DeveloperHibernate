package dao.hibernate;

import dao.SkillDAO;
import dao.util.HibernateUtil;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSkillDAOImpl implements SkillDAO {
    @Override
    public void create(Skill skill) {

    }

    @Override
    public Skill getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Skill> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction;
        List<Skill> skills = null;
        try {
            transaction = session.beginTransaction();
            skills = session.createQuery("FROM Skill ").list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error at getAll");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return skills;
        }
    }
}