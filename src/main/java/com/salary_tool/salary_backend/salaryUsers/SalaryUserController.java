package com.salary_tool.salary_backend.salaryUsers;

import com.salary_tool.salary_backend.InfoUsers.InfoUser;
import com.salary_tool.salary_backend.InfoUsers.InfoUserService;
import com.salary_tool.salary_backend.SalaryInDTO;
import com.salary_tool.salary_backend.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class SalaryUserController {
    @Autowired
    private SalaryUserService salaryUserService;

    @Autowired
    private InfoUserService infoUserService;
    @CrossOrigin(origins = "*")
    @GetMapping("/salary/{id}")
    public ResponseEntity<SalaryUser>  getSalaryById(@PathVariable UUID id){
        return new ResponseEntity<SalaryUser>(salaryUserService.getUser(id),HttpStatus.OK);

    }
    @PostMapping("/salary")
    public void createSalaryUser(@RequestBody UserDataInDTO data){
        //DTO= name:string/surname:string/mail:string/expertise:double/responsibility:double/tenure:double/hpw:double/isEmployee:boolean/startDate:double

        InfoUser infoUser = new InfoUser(data.getName(),data.getSurname(),data.getMail());
        SalaryUser salaryUser = new SalaryUser(data.getExpertise(),data.getResponsibility(),data.getHoursPerWeek(),data.isEmployee(),data.getMillis());

        infoUser.setSalaryUser(salaryUser);
       // salaryUser.setInfoUser(infoUser);

        //infoUserService.createUser(infoUser);
        salaryUserService.createUser(salaryUser);
//        System.out.println(infoUser.toString());
//        System.out.println(salaryUser.toString());
    }

    //Post /salary/{id} to update existing user


    @GetMapping("/salary")
    public ResponseEntity<List<SalaryUser>> getOneSalaryUser(){
        return new ResponseEntity<List<SalaryUser>>( salaryUserService.getUsers(), HttpStatus.OK);

    }
    @DeleteMapping("/salary")
    public void deleteUserById(@RequestBody UUID id){
        System.out.println("la id= "+id);
        salaryUserService.deleteUser(id);
    }
}
