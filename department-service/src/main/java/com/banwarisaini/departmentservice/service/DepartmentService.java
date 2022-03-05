package com.banwarisaini.departmentservice.service;

import com.banwarisaini.departmentservice.entity.Department;
import com.banwarisaini.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("inside the saveDepartment method in DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentByDepartmentId(Long departmentId) {
        log.info("inside the findDepartmentByDepartmentId method in DepartmentService");
        return departmentRepository.findDepartmentByDepartmentId(departmentId);
    }
}
