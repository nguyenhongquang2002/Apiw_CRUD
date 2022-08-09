package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Class;
import com.example.apiwcrud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value ="class",method = RequestMethod.GET)
    public ResponseEntity<List<Class>> findAllClass(){
        List<Class> lsClass = classService.findAll();
        if(lsClass.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Class>>(lsClass,HttpStatus.OK);
    }



    //userbyname?name=quang
    @RequestMapping(value ="classbyname",method = RequestMethod.GET)
    public ResponseEntity<List<Class>> findAllClass(@PathParam("name") String name){
        List<Class> lsClass = classService.findAllByName(name);
        if(lsClass.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Class>>(lsClass,HttpStatus.OK);
    }




    @RequestMapping(value ="createclass",method = RequestMethod.POST)
    public ResponseEntity<Class> saveNewClass(@RequestBody Class c ){
        classService.saveClass(c);
        return new ResponseEntity<Class>(c,HttpStatus.OK);
    }
//    http://localhost:8080/updateUser
    @RequestMapping(value ="updateClass",method = RequestMethod.PUT)
    public ResponseEntity<Class> saveNewClass(
        @Param("id") Integer id,
        @RequestBody Class c ){
        Class oldClass = classService.findById(id);
        oldClass.setName(c.getName());
        oldClass.setRoom(c.getRoom());
        oldClass.setNote(c.getNote());
        classService.saveClass(oldClass);
        return new ResponseEntity<Class>(oldClass,HttpStatus.OK);
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

    @RequestMapping(value ="deleteClass/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Class> deleteClass(@PathVariable(value = "id") Integer id){
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }
}
