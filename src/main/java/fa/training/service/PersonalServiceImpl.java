package fa.training.service;

import fa.training.dao.PersonalDao;
import fa.training.dto.PersonalForCreate;
import fa.training.dto.PersonalForUpdate;
import fa.training.entity.Personal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PersonalServiceImpl implements PersonalService  {

    @Autowired
    private PersonalDao personalDao;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    @Transactional
    public void save(PersonalForCreate personalDto) {
        Personal personal = change(personalDto);
        personalDao.save(personal);
    }

    @Override
    @Transactional
    public List<Personal> getAll() {
        return personalDao.getAll() ;
    }

    @Override
    @Transactional
    public List<Personal> getByFirstName(String firstName)  {
        return personalDao.getByFirstName(firstName);
    }

    @Override
    @Transactional
    public void update(PersonalForUpdate personalDto)  {
        Personal personal = change(personalDto);
        personalDao.update(personal);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        personalDao.deleteById(id);
    }
    @Override
    @Transactional
    public PersonalForUpdate getById(int id){
       Personal personal = (Personal) personalDao.getById(id);
       PersonalForUpdate personalDto = change(personal);
        return personalDto;
    }

    @Override
    public Personal change(PersonalForCreate personalDto) {
        String firstName =personalDto.getFirstName();
        String lastName = personalDto.getLastName();
        String gender = personalDto.getGender();
        String phone = personalDto.getPhone();
        String email = personalDto.getEmail();
         String live = personalDto.getLive();
        String[] hobbiesList = personalDto.getHobbies();
        String description = personalDto.getDescription();
        String hobbies ="";
        for (String element:hobbiesList
             ) {
                hobbies = hobbies +","+element;
            }

        Personal personal = new Personal(firstName,lastName,gender,phone,email,live,hobbies.substring(1),description);
        return personal;
    }

    @Override
    @Transactional
    public List<Personal>  findAll(Integer offset, Integer maxResult) {
        return (List<Personal>) personalDao.findAll(offset,maxResult);
    }

    @Override
    @Transactional
    public Long count() {
        return personalDao.count();
    }

    @Override
    public Personal change(PersonalForUpdate personalDto){
        int id = personalDto.getId();
        String firstName =personalDto.getFirstName();
        String lastName = personalDto.getLastName();
        String gender = personalDto.getGender();
        String phone = personalDto.getPhone();
        String email = personalDto.getEmail();
        String live = personalDto.getLive();
        String[] hobbiesList = personalDto.getHobbies();
        String description = personalDto.getDescription();
        String hobbies ="";
        for (String element:hobbiesList
        ) {
            hobbies = hobbies +","+element;
        }

        Personal personal = new Personal(id,firstName,lastName,gender,phone,email,live,hobbies.substring(1),description);
        return personal;
    }

//    @Override
//    public PersonalForCreate change(Personal personal) {
//        String firstName =personal.getFirstName();
//        String lastName = personal.getLastName();
//        String gender = personal.getGender();
//        String phone = personal.getPhone();
//        String email = personal.getEmail();
//        String live = personal.getLive();
//        String hobbies = personal.getHobbies();
//        String description = personal.getDescription();
//        String[] hobbiesList = hobbies.split(",");
//        PersonalForCreate personalForCreate = new PersonalForCreate(firstName,lastName,gender,phone,email,live,hobbiesList,description);
//        return personalForCreate;
//    }
    @Override
    public PersonalForUpdate change(Personal personal){
        int id = personal.getId();
        String firstName =personal.getFirstName();
        String lastName = personal.getLastName();
        String gender = personal.getGender();
        String phone = personal.getPhone();
        String email = personal.getEmail();
        String live = personal.getLive();
        String hobbies = personal.getHobbies();
        String description = personal.getDescription();
        String[] hobbiesList = hobbies.split(",");
        PersonalForUpdate personalDto = new PersonalForUpdate(id,firstName,lastName,gender,phone,email,live,hobbiesList,description);
        return personalDto;
    }
}
