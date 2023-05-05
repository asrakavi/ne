package com.example.SpringbootCrud.Controller;

import com.example.SpringbootCrud.Entity.Subject;
import com.example.SpringbootCrud.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @RequestMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubject() {

        List<Subject> list=subjectService.getAllSubjects();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


//@RequestMapping(method=RequestMethod.GET,value="/subjects/{id}")
//    public ResponseEntity<Subject> getSubject(@PathVariable String id){
//        Subject sub=subjectService.getSubject(id);
//        if(sub==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.of(Optional.of(sub));
//    }
//

    //THIS IS MADE BY AVANISH RANA and edited by avi


//    he Indian Premier League is a men's Twenty20 cricket league that is annually held in India and contested by ten
//    city-based franchise teams. The Board of Control for Cricket in India founded the league in 2007.

    @RequestMapping(method=RequestMethod.GET,value="/subjects/{id}")
    public ResponseEntity<Optional<Subject>> getSubject(@PathVariable String id){
        Optional<Subject> sub=subjectService.getSubject(id);
        if(sub==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(sub));
    }


    @RequestMapping(method= RequestMethod.POST, value="/subjects")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){

        Subject subj=null;
        try{
            subj=subjectService.addSubject(subject);
            System.out.println(subj);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method= RequestMethod.PUT, value="/subjects/{id}")
    public ResponseEntity<Void> updateSubject(@PathVariable String id, @RequestBody Subject subject){

        try {
            subjectService.updateSubject(id, subject);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


@RequestMapping(method = RequestMethod.DELETE, value="/subjects/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id){

        try {
            subjectService.deleteSub(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
