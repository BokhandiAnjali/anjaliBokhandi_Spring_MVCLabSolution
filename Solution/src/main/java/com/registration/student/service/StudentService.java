package com.registration.student.service;

import com.registration.student.dto.Student;
import com.registration.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> listAll(long id)
    {
        if(id>0){
          return Arrays.asList(get(id));
        }else {
            System.out.println(repository.findAll());
            return repository.findAll();
        }
    }


    public void saveOrUpdate(Student std) {
        repository.save(std);
    }

    public Student get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        try {
            repository.deleteById(id);
        }catch (Exception exception){
            throw new RuntimeException("There is exception in deleting");
        }
    }
}
