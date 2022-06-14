package de.telran.mvcpeople.controller;

import de.telran.mvcpeople.model.Person;
import de.telran.mvcpeople.service.PeopleService;
import de.telran.mvcpeople.webmodel.PeopleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeopleWebController {

    PeopleService service=new PeopleService();

    @GetMapping("/people")
    public String getIndexForm(Model model){
        model.addAttribute("peopleForm",new PeopleForm());
        model.addAttribute("people",service.getPeople());

        return "index";
    }
    @PostMapping("/addPerson")
    public String addPerson(Model model,PeopleForm form){
        Person person = new Person(form.getFirstName(),form.getLastName());
        service.addPerson(person);

        model.addAttribute("people",service.getPeople());

        return "index";


    }

}
