package com.example.SpringbootCrud.Service;

import com.example.SpringbootCrud.Entity.Subject;
import com.example.SpringbootCrud.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    public SubjectRepository subjectRepo;

    public List<Subject> getAllSubjects() {

        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findAll().forEach(subjects::add);

        return subjects;
    }


    //    public Subject getSubject(String id) {
//        Subject sub=null;
//        try{
//            sub=subjectRepo.FindbyId(id);
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return sub;
//    }

    public Optional<Subject> getSubject(String id) {

        return subjectRepo.findById(id);
    }

    public Subject addSubject(Subject subject) {
        Subject sub1= subjectRepo.save(subject);
        return sub1;
    }

    public void updateSubject(String id, Subject subject) {
        subjectRepo.save(subject);
    }

    public void deleteSub(String id) {
        subjectRepo.deleteById(id);
    }


}

