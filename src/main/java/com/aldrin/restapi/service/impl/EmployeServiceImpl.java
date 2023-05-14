/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.restapi.service.impl;

import com.aldrin.restapi.model.Employee;
import com.aldrin.restapi.repository.EmployeeRepository;
import com.aldrin.restapi.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ALDRIN
 */
@Service
public class EmployeServiceImpl implements EmployeeService {

//    private static List<Employee> list = new ArrayList<>();
//    static{
//        Employee e = new Employee();
//        e.setName("Aldrin");
//        e.setAge(31L);
//        e.setDepartment("IT");
//        e.setEmail("aldrincabusog@gmail.com");
//        e.setLocation("Philippines");
//        list.add(e);
//        
//        e.setName("Justine");
//        e.setAge(31L);
//        e.setDepartment("AG");
//        e.setEmail("jkoybedro@gmail.com");
//        e.setLocation("China");
//        list.add(e);
//    }
    @Autowired
    private EmployeeRepository empRepository;

    @Override
    public List<Employee> getEmployee() {
        return empRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = empRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id" + id);
    }

    @Override
    public void deleteEmployee(Long id) {
         empRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return empRepository.save(employee);
    }

}
