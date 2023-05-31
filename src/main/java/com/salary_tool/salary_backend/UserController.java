package com.salary_tool.salary_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>( userService.getUsers(), HttpStatus.OK);
    }
//    @GetMapping("/getOneUser")
//    public void getOneUser(){
//        return new ResponseEntity<List<User>>( userService.getOneUser(), HttpStatus.OK);
//    }

    @GetMapping("/createOneUser")
    public User getUneUserTest(@RequestBody String name){
        User testuser = new User(name,(name+"@mail.com"));
        userService.createUser(testuser);

        return testuser;
    }

    @DeleteMapping("/byName")
    public void deleteByName(String name){


    }


    @DeleteMapping("/deleteOneUser")
    public void deleteBasedOnId(@RequestBody UUID userId){

        userService.deleteOneUser(userId);

    }

    @GetMapping("/oneName")
    public ResponseEntity<List<User>> getUserByLasName(@RequestBody String name){

        List<User> users = userService.test(name);
        for(User user: users){

            System.out.println("Last name search ="+ user);
            //return user;
        }
        return new ResponseEntity<List<User>>( users, HttpStatus.OK);
    }

    }


