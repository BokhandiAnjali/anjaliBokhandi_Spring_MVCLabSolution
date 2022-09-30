package com.registration.student.controller;

import com.registration.student.dto.Student;
import com.registration.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/student/")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/getStudents")
    public ResponseEntity getStudents(@RequestParam long id) {
        List<Student> liststudent = service.listAll(id);
        return new ResponseEntity(liststudent, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity saveStudent(@Valid @RequestBody Student std)
    {
        service.saveOrUpdate(std);
        return new ResponseEntity("Record is updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentPage(@PathVariable(name = "id") int id) {
            service.delete(id);
        return new ResponseEntity("", HttpStatus.OK);
    }
}
