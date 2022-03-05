package com.banwarisaini.userservice.service;

import com.banwarisaini.userservice.entity.User;
import com.banwarisaini.userservice.model.Department;
import com.banwarisaini.userservice.model.ResponseTemplate;
import com.banwarisaini.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside the saveUser method in UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("inside the getUserWithDepartment method in UserService");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findUserByUserId(userId);
        Department department = restTemplate.getForObject("http://API-GATEWAY/departments/"+ user.getDepartmentId(), Department.class);
        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
