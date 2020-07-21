package com.sugondo.springtest.controller;

import com.sugondo.springtest.dao.Person;
import com.sugondo.springtest.dao.ResponseWrapper;
import com.sugondo.springtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;


@RestController
public class ApiController {
    @Autowired
    private PersonRepository repository;

    private final static int DIGIT_SUCCESS = 1;
    private final static int DIGIT_FAILED = 0;
    private final static String STRING_SUCCESS = "success";
    private final static String STRING_FAILED = "failed";

    @GetMapping("/listPerson")
    public ResponseWrapper listPerson() {
        ResponseWrapper result = getAllPerson();
        return result;
    }

    @PostMapping("/addPerson")
    public ResponseWrapper addPerson(@RequestBody Person person) {
        ResponseWrapper result = addPersonData(person);
        return  result;
    }

    @PostMapping("/editPerson")
    public ResponseWrapper editPerson(@RequestBody Person person) {
        ResponseWrapper result = editPersonData(person);
        return  result;
    }

    @PostMapping("/deletePerson")
    public ResponseWrapper deletePerson(@RequestBody Person person) {
        ResponseWrapper result = deletePersonData(person);
        return  result;
    }

    @GetMapping("/triangle")
    public String generateTriangle(@RequestParam("count") int count){
        String finalResult = "";

        for(int i=count; i>0 ; i--){
            String result = "";
            for(int j=0; j<i-1; j++){
                if(j==0){
                    result += " ";
                } else {
                    result += "  ";
                }
            }
            for(int k=0; k<count-i+1; k++){
                if(i==1 && k==0) {
                    result += "#";
                } else {
                    result += " #";
                }
            }
            result+="\n\n";
            finalResult+=result;
        }

        return finalResult;
    }

    public ResponseWrapper getAllPerson()
    {
        ResponseWrapper responseWrapper;
        try {
            List<Person> result = (List<Person>) repository.findAll();
            if (result != null && result.size() > 0) {
                responseWrapper = new ResponseWrapper(DIGIT_SUCCESS, STRING_FAILED, result);
            } else {
                responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, null);
            }
        } catch (PersistenceException e){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, e.getMessage());
        } catch (Exception ex){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, ex.getMessage());
        }
        return responseWrapper;
    }

    public ResponseWrapper addPersonData(Person person){
        ResponseWrapper responseWrapper;
        String detailed;
        try {
            if (person.getName() != null
                    && !person.getName().equals("")
                    && person.getPhone() != null
                    && !person.getPhone().equals("")) {
                Person result = repository.save(person);
                if (result != null) {
                    detailed = "success add new person, id: " + result.getId() + ", name: " + result.getName()
                            + ", phone: " + result.getPhone();
                    responseWrapper = new ResponseWrapper(DIGIT_SUCCESS, STRING_SUCCESS, detailed);
                } else {
                    detailed = "failed add new person, name: " + person.getName() + ", phone: " + person.getPhone();
                    responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, detailed);
                }


            } else {
                detailed = "data not complete name: " + person.getName() + ", phone: " + person.getPhone();
                responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, detailed);
            }
        } catch (PersistenceException e) {
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, e.getMessage());
        } catch (Exception ex){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, ex.getMessage());
        }

        return responseWrapper;
    }

    public ResponseWrapper editPersonData(Person person){
        ResponseWrapper responseWrapper;
        String detailed;

        try {
            Person resultFind = repository.findById(person.getId()).get();

            if(resultFind != null){
                repository.save(person);
                detailed = "success update new person, id: " + person.getId() + ", name: " + person.getName()
                        + ", phone: " + person.getPhone();
                responseWrapper = new ResponseWrapper(DIGIT_SUCCESS, STRING_SUCCESS, detailed);
            } else {
                detailed = "data not found id: "+person.getId();
                responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, detailed);
            }
        } catch (PersistenceException e){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, e.getMessage());
        } catch (Exception ex){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, ex.getMessage());
        }

        return responseWrapper;
    }

    public ResponseWrapper deletePersonData(Person person){
        ResponseWrapper responseWrapper;
        String detailed;

        try {
            Person resultFind = repository.findById(person.getId()).get();

            if(resultFind != null){
                repository.delete(resultFind);
                detailed = "success delete new person, id: " + person.getId() + ", name: " + person.getName()
                        + ", phone: " + person.getPhone();
                responseWrapper = new ResponseWrapper(DIGIT_SUCCESS, STRING_SUCCESS, detailed);
            } else {
                detailed = "data not found id: "+person.getId();
                responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, detailed);
            }
        } catch (PersistenceException e){
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, e.getMessage());
        } catch (Exception ex) {
            responseWrapper = new ResponseWrapper(DIGIT_FAILED, STRING_FAILED, ex.getMessage());
        }

        return responseWrapper;
    }

}
