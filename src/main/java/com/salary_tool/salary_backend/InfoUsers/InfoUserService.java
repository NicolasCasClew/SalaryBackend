package com.salary_tool.salary_backend.InfoUsers;

import com.salary_tool.salary_backend.salaryUsers.SalaryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Service

public class InfoUserService {
    @Autowired
    private InfoUserRepository infoUserRepository;

    public void createUser(InfoUser user) {infoUserRepository.save(user);}
    public InfoUser getUser (UUID id) {return infoUserRepository.getById(id);
    }

    public List<InfoUser> getUsers(){
        return infoUserRepository.findAll();
    }


    public void deleteUser(UUID id) {
        infoUserRepository.deleteById(id);
    }
}
