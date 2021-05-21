package com.example.jpasetting.model;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        List<User> user = userRepository.findAll();
        return user;
    }

    public Page<User> getQuerydslUser(){
        return userRepository.findByAll();
    }

    @Transactional
    public User saveUser(User target){
        return userRepository.save(target);
    }
}
