package fa.training.controller;


import fa.training.dto.PersonalForCreate;
import fa.training.dto.PersonalForUpdate;
import fa.training.entity.Personal;
import fa.training.service.PersonalService;
import fa.training.utils.PersonalListOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @Autowired
    private PersonalListOptions listOptions;


    @GetMapping(path = "/register")
    public String getFormRegister(Model theModel){
        PersonalForCreate personalForCreate = new PersonalForCreate();
        theModel.addAttribute("genderOptions",listOptions.getOptionGender());
        theModel.addAttribute("liveOptions",listOptions.getOptionLive());
        theModel.addAttribute("hobbiesOptions",listOptions.getOptionsHobbies());
        theModel.addAttribute("personal",personalForCreate);
        return "personal-form-register";
    }

    @PostMapping(path = "/register")
    public String addDatabase (@ModelAttribute ("personal") @Valid PersonalForCreate personalForCreate, BindingResult result,Model theModel) throws IOException {
        if (personalForCreate.getFirstName().isEmpty()){
            throw new IOException("could not insert");
        }
        theModel.addAttribute("genderOptions",listOptions.getOptionGender());
        theModel.addAttribute("liveOptions",listOptions.getOptionLive());
        theModel.addAttribute("hobbiesOptions",listOptions.getOptionsHobbies());
        if(result.hasErrors()){
            return "personal-form-register";
        }
        personalService.save(personalForCreate);
        return "redirect:/personal/list";
    }

    @GetMapping(path = "/list")
    public String list(Model theModel, Integer offset, Integer maxResults){
        List<Personal> personals = personalService.findAll(offset,maxResults);
        theModel.addAttribute("count",personalService.count());
        theModel.addAttribute("offset",offset);
        theModel.addAttribute("personals",personals);
        return "personal-list";
    }

    @PostMapping(path ="/search")
    public String search(@ModelAttribute("firstName") String firstName,Model theModel){
        List<Personal> personal;
        if(firstName.isEmpty()){
            personal = personalService.getAll();
        }else {
            personal = personalService.getByFirstName(firstName);
        }
        theModel.addAttribute("personals",personal);
        return "personal-list";
    }
    @GetMapping (path = "/update")
    public String edit(@RequestParam("id") int id,Model theModel){
        PersonalForUpdate personal = personalService.getById(id);
        theModel.addAttribute("personal",personal);
        theModel.addAttribute("id",id);
        theModel.addAttribute("genderOptions",listOptions.getOptionGender());
        theModel.addAttribute("liveOptions",listOptions.getOptionLive());
        theModel.addAttribute("hobbiesOptions",listOptions.getOptionsHobbies());
        return "personal-edit";
    }
    @PostMapping(path = "/update")
    public String update(@ModelAttribute("personal") PersonalForUpdate personalDto){
        personalService.update(personalDto);
        return "redirect:/personal/list";
    }

    @PostMapping(path = "/cancel")
    public String cancel(){
        return "redirect:/personal/list";
    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam("id") int id){
        personalService.deleteById(id);
        return "redirect:/personal/list";
    }

    @ExceptionHandler({IOException.class, java.sql.SQLException.class})
    public ModelAndView handleIOException(Exception ex){
        ModelAndView model = new ModelAndView("IOError");
        model.addObject("exception", ex.getMessage());
        return model;
    }


}
