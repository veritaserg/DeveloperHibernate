package dao.hibernate;

import dao.AbstractDao;
import dao.SkillDAO;
import dao.util.HibernateUtil;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSkillDAOImpl extends AbstractDao<Skill> implements SkillDAO {

   public HibernateSkillDAOImpl(){
       super.settClass(Skill.class);
   }

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
       return getAllAbstract();
    }
}