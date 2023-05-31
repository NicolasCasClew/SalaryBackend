package com.salary_tool.salary_backend.salaryUsers;

import com.salary_tool.salary_backend.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalaryUserService {
    @Autowired
    private  SalaryUserRepository salaryUserRepository;

    public List<SalaryUser> getUsers(){
        return salaryUserRepository.findAll();
    }
    public SalaryUser getUser(UUID id){return salaryUserRepository.getById( id);}

    public void createUser(SalaryUser user) {salaryUserRepository.save(user);}

    public void deleteUser(UUID id){salaryUserRepository.deleteById(id);}

}
