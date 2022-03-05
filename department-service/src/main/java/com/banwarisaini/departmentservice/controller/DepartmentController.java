package com.banwarisaini.departmentservice.controller;

import com.banwarisaini.departmentservice.entity.Department;
import com.banwarisaini.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment( @RequestBody Department department){
        log.info("inside the saveDepartment in the DepartmentController ");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside the findDepartmentById in the DepartmentController ");
        return departmentService.findDepartmentByDepartmentId(departmentId);
    }

}
