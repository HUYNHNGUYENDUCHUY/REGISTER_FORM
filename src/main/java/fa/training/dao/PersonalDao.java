package fa.training.dao;

import fa.training.entity.Personal;

import java.util.List;

public interface PersonalDao {
    void save(Personal personal) ;

    List<Personal> getAll() ;

    List<Personal> getByFirstName(String firstName) ;

    List<Personal> findAll(Integer minResult , Integer maxResult);
    Long count();
    void update( Personal personal) ;

   void deleteById(int id) ;


    Personal getById(int id);
}
