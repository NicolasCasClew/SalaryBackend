package com.salary_tool.salary_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getOneUser(UUID id){
        return userRepository.getReferenceById(id);
    }
    public void createUser(User user) {userRepository.save(user);}

    public void deleteOneUser(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> test(String name){
        return userRepository.findByName(name);
    }
}
