package com.test1.api_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //User user = new User("16","Jimmy","jimmaik.com");
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>( userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/oneUser")
    public User getUneUserTest(){
        User testuser = new User("44","test5","test5@mail.com");

        return testuser;
    }
    @PostMapping("/processNumbers")
    public ResponseEntity<String> processNumbers(@RequestBody List<Integer> numbers) {
        // process the numbers here
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        for (int i: numbers
             ) {
            System.out.println("Numero= "+i+"  suma= "+ sum);
        }

        // return the result
        return ResponseEntity.ok(sum.toString());
    }
}
