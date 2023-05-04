package com.example.SpringbootCrud.Controller;

import com.example.SpringbootCrud.Entity.Subject;
import com.example.SpringbootCrud.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @RequestMapping("/subjects")
    public List<Subject> getAllSubject() {

        return subjectService.getAllSubjects();
    }


@RequestMapping(method=RequestMethod.GET,value="/subjects/{id}")
    public Optional<Subject> getSubject(@PathVariable String id){
        return subjectService.getSubject(id);
    }


    @RequestMapping(method= RequestMethod.POST, value="/subjects")
    public void addSubject(@RequestBody Subject subject){

        subjectService.addSubject(subject);
    }


    @RequestMapping(method= RequestMethod.PUT, value="/subjects/{id}")
    public void updateSubject(@PathVariable String id, @RequestBody Subject subject){

        subjectService.updateSubject(id,subject);
    }


@RequestMapping(method = RequestMethod.DELETE, value="/subjects/{id}")
    public void deleteSubject(@PathVariable String id){

        subjectService.deleteSub(id);
    }

}
