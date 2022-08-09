package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.User;
import com.example.apiwcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
     UserService userService;

    @RequestMapping(value ="user",method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser(){
        List<User> lsUser = userService.findAll();
        if(lsUser.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<User>>(lsUser,HttpStatus.OK);
    }



    //userbyname?name=quang
    @RequestMapping(value ="userbyname",method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser(@PathParam("name") String name){
        List<User> lsUser = userService.findAllByName(name);
        if(lsUser.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<User>>(lsUser,HttpStatus.OK);
    }




    @RequestMapping(value ="create",method = RequestMethod.POST)
    public ResponseEntity<User> saveNewUser(@RequestBody User user ){
        userService.saveUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
//    http://localhost:8080/updateUser
    @RequestMapping(value ="updateUser",method = RequestMethod.PUT)
    public ResponseEntity<User> saveNewUser(
        @Param("id") Integer id,
        @RequestBody User user ){
        User oldUser = userService.findById(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<User>(oldUser,HttpStatus.OK);
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

    @RequestMapping(value ="deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
