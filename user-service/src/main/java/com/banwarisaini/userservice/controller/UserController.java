package com.banwarisaini.userservice.controller;

import com.banwarisaini.userservice.entity.User;
import com.banwarisaini.userservice.model.ResponseTemplate;
import com.banwarisaini.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser( @RequestBody User user){
        log.info("inside the saveUser method in UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside the getUserWithDepartment method in UserController");
        return userService.getUserWithDepartment(userId);
    }

}
