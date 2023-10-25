package fa.training.utils;

import org.springframework.stereotype.Service;

@Service
public class PersonalListOptions {

    public String[] getOptionGender(){
        String[] gender= {"Male","Female"};
        return gender;
    }
    public String[] getOptionLive(){
        String[] live= {"Europe","Africa","Australia","Asia","America"};
        return live;
    }
    public String[] getOptionsHobbies(){
        String[] hobbies = {"Swimming","Cooking","Shopping","Sport","Dance","Sing"};
        return hobbies;
    }
}
