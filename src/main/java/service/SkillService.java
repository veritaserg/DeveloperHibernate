package service;

import dao.hibernate.HibernateSkillDAOImpl;
import model.Skill;
import java.util.List;

public class SkillService {
    HibernateSkillDAOImpl hibernateSkillDAO;
    public SkillService(){
       hibernateSkillDAO = new HibernateSkillDAOImpl();
    }
    public void create(Skill skill) {
        hibernateSkillDAO.create(skill);
    }

    public Skill getById(Long id) {
        return hibernateSkillDAO.getById(id);
    }

    public void update(Skill skill) {
        hibernateSkillDAO.update(skill);
    }

    public void delete(Long id) {
        hibernateSkillDAO.delete(id);
    }

    public List<Skill> getAll() {
        return hibernateSkillDAO.getAll();
    }
}
