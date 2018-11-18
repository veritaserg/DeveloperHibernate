package service;

import dao.hibernate.HibernateDeveloperDAOImpl;
import model.Developer;

import java.util.List;

public class DeveloperService {
    HibernateDeveloperDAOImpl hibernateDeveloperDAO;
    public DeveloperService(){
        hibernateDeveloperDAO = new HibernateDeveloperDAOImpl();
    }
    public void create(Developer developer) {
    hibernateDeveloperDAO.create(developer);
    }

    public Developer getById(Long id) {
       return hibernateDeveloperDAO.getById(id);
    }

    public void update(Developer developer) {
       hibernateDeveloperDAO.update(developer);
    }

    public void delete(Long id) {
       hibernateDeveloperDAO.delete(id);
    }

    public List<Developer> getAll() {
      return hibernateDeveloperDAO.getAll();
    }
}

