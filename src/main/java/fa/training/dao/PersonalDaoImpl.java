package fa.training.dao;

import fa.training.entity.Personal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonalDaoImpl implements PersonalDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Personal personal) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(personal);
    }

    @Override
    public List<Personal> getAll()  {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From Personal ";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<Personal> getByFirstName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From Personal p Where p.firstName =:firstName";
        Query query = session.createQuery(hql);
        query.setParameter("firstName",firstName);
        List<Personal> personalList = query.list();
        return personalList;

    }

    @Override
    public List<Personal> findAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From Personal ";
        Query query = session.createQuery(hql);
        query.setFirstResult(offset != null?offset : 0);
        query.setMaxResults(maxResult != null?maxResult :3);
        return query.list();
    }

    @Override
    public Long count() {
        Session session =sessionFactory.getCurrentSession();
        String hql = "Select count(p) From Personal p";
        Query query = session.createQuery(hql);
        return (Long) query.uniqueResult();
    }

    @Override
    public void update( Personal personal)  {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(personal);
    }

    @Override
    public void deleteById(int id )  {
        Session session = sessionFactory.getCurrentSession();
        Personal personal = session.byId(Personal.class).load(id);
        session.delete(personal);
    }
    @Override
    public Personal getById(int id){
        Session session = sessionFactory.getCurrentSession();
        String hql = "From Personal p where p.id =:id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        return (Personal) query.uniqueResult();
    }


}
