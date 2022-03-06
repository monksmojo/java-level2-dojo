package com.example.restfulapi2.personapp.service;

import com.example.restfulapi2.personapp.model.Person;
import com.example.restfulapi2.personapp.model.Person1;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Service
public class PersonService {

    private static List<Person> personList=new ArrayList<Person>();
    private static List<Person1> personList1=new ArrayList<Person1>();
    private static int personCount=4;

    static { // to populate list of person1
        personList.add(new Person(1,"pass1","thor",23,"chugging"));
        personList.add(new Person(2,"pass2","hella",20,"destroying"));
        personList.add(new Person(3,"pass3","loki",22,"mischief"));
        personList.add(new Person(4,"pass4","hulk",26,"smash"));

        //to populate list of person2
        personList1.add(new Person1(1,"thor","odin son","pass1",23,"chugging"));
        personList1.add(new Person1(2,"hella","odin duaghter","pass2",20,"destroying"));
        personList1.add(new Person1(3,"loki","odin son","pass3",22,"mischief"));
        personList1.add(new Person1(4,"hulk","banner","pass4",26,"smash"));

    }


    // internationalization
    // setting up locale and default locale for greetings in different language
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
    // also added spring.messages.basename=messages to application.properties


    // logic to return list of person //  URI versioning

    public List<Person> getPersonList() {
        return personList;
    }

    // logic to return list of person //  URI versioning
    public List<Person1> getPersonList1() {
        return personList1;
    }

    // logic to return a specific person
    public Person getPerson(Integer id){
        for(Person p:personList){
            if(id==p.getId()){
                return p;
            }
        }
        return null;
    }

    // logic to add a person to the list
    public Person addPerson(Person person){
        if(person.getId()==null){
            person.setId(personCount+1);
            personList.add(person);
            return person;
        }
        else {
            personList.add(person);
            return person;
        }
    }


    // logic to delete a person
    public Person removePerson(Integer id) {
        Iterator<Person> pitr=personList.iterator();
        while (pitr.hasNext()){
            Person p=pitr.next();
            if (p.getId()==id){
                pitr.remove(); // will remove person from list
                return p;
            }
        }
        return null;
    }
}
