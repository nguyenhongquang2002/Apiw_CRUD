package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Student;
import com.example.apiwcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value ="list",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAllStudent(){
        List<Student> lsStudent = studentService.findAll();
        if(lsStudent.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Student>>(lsStudent,HttpStatus.OK);
    }



    //userbyname?name=quang
    @RequestMapping(value ="studentbyname",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAllStudent(@PathParam("name") String name){
        List<Student> lsStudent = studentService.findAllByName(name);
        if(lsStudent.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Student>>(lsStudent,HttpStatus.OK);
    }


    @RequestMapping(value ="create",method = RequestMethod.POST)
    public ResponseEntity<Student> saveNewStudent(@RequestBody Student s ){
        studentService.saveStudent(s);
        return new ResponseEntity<Student>(s,HttpStatus.OK);
    }
//    http://localhost:8080/updateUser
    @RequestMapping(value ="update",method = RequestMethod.PUT)
    public ResponseEntity<Student> saveNewStudent(
        @Param("id") Integer id,
        @RequestBody Student s ){
        Student sStudent = studentService.findById(id);
        sStudent.setName(s.getName());
        sStudent.setEmail(s.getEmail());
        sStudent.setPhone(s.getPhone());
        sStudent.setGender(s.getGender());
        sStudent.setNote(s.getNote());
        sStudent.setClassId(s.getClassId());
        studentService.saveStudent(s);
        return new ResponseEntity<Student>(s,HttpStatus.OK);
    }
//    @RequestMapping(value ="updateUser1/{id}",method = RequestMethod.PUT) // "updateUser1/{id}"
//    public ResponseEntity<User> saveNewUser(
//            @PathVariable(value = "id") Integer id, //@PathVariable(value = "id")
//            @RequestBody User user ){
//        User oldUser = userService.findById(id);
//        oldUser.setName(user.getName());
//        oldUser.setEmail(user.getEmail());
//        oldUser.setPhone(user.getPhone());
//        userService.saveUser(oldUser);
//        return new ResponseEntity<User>(oldUser,HttpStatus.OK);
//    }

    @RequestMapping(value ="delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()  + " "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
