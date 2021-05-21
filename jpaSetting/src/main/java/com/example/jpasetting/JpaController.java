package com.example.jpasetting;

import com.example.jpasetting.model.User;
import com.example.jpasetting.model.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JpaController {

    private final UserService userService;

    @GetMapping(value = "/user")
    public String getUser(){
        List<User>  userList = userService.getUsers();
        String json = new Gson().toJson(userList);
        return json;
    }

    @GetMapping(value = "/save/user")
    public String saveUser(){
        User user = User.builder().username("yoon").userType("Personal").password("123456").build();
        User target = userService.saveUser(user);
        String json = new Gson().toJson(target);
        return json;
    }
}
