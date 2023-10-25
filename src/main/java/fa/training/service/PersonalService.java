package fa.training.service;

import fa.training.dto.PersonalForCreate;
import fa.training.dto.PersonalForUpdate;
import fa.training.entity.Personal;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonalService {
    void save(PersonalForCreate personalDto);
    List<Personal> getAll() ;
    List<Personal> getByFirstName(String firstName) ;

    void update(PersonalForUpdate personalDto);
    void deleteById(int id);

    @Transactional
    PersonalForUpdate getById(int id);

    // change data from PersonalForCreate to Personal
    Personal change(PersonalForCreate personalDto);

    List<Personal> findAll(Integer minResult ,Integer maxResult );
    Long count();


    Personal change(PersonalForUpdate personalDto);

    PersonalForUpdate change(Personal personal);
}
