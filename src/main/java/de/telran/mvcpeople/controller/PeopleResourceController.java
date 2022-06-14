package de.telran.mvcpeople.controller;

import de.telran.mvcpeople.model.Person;
import de.telran.mvcpeople.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleResourceController {

    private PeopleService peopleService =new PeopleService();

    //TODO
    //1.get List of persons
    //2. add person
    //get person by id

    @GetMapping("/people")
    public List<Person> getPeople(){
        return peopleService.getPeople();
    }
    @GetMapping("/people/{id}")
    public Person getPersonById(@PathVariable int id){
        return peopleService.getPersonById(id);
    }

    @PostMapping("/people")
    public void addPerson(@RequestBody Person person){
        peopleService.addPerson(person);
    }
}
