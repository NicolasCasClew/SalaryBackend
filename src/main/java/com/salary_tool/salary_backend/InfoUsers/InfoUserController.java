package com.salary_tool.salary_backend.InfoUsers;

import com.salary_tool.salary_backend.salaryUsers.SalaryUser;
import com.salary_tool.salary_backend.salaryUsers.UserDataInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class InfoUserController {
    @Autowired
    private InfoUserService infoUserService;

    @GetMapping("/users")
    public ResponseEntity<List<InfoUser>> geInfoUsers(){
        return new ResponseEntity<List<InfoUser>>( infoUserService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<InfoUser> getUserById(@PathVariable UUID id){
        return new ResponseEntity<InfoUser>(infoUserService.getUser(id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable UUID id){
        infoUserService.deleteUser(id);

    }
    @PostMapping("/users")
    public void createInfoUser(@RequestBody UserDataInDTO data){
        //DTO= name:string/surname:string/mail:string/expertise:double/responsibility:double/tenure:double/hpw:double/isEmployee:boolean/startDate:double

        InfoUser infoUser = new InfoUser(data.getName(),data.getSurname(),data.getMail());
        SalaryUser salaryUser = new SalaryUser(data.getExpertise(),data.getResponsibility(),data.getHoursPerWeek(),data.isEmployee(),data.getMillis());

        infoUser.setSalaryUser(salaryUser);
        // salaryUser.setInfoUser(infoUser);

        //infoUserService.createUser(infoUser);
        infoUserService.createUser(infoUser);
//        System.out.println(infoUser.toString());
//        System.out.println(salaryUser.toString());
    }
}
