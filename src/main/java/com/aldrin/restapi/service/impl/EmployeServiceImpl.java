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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return empRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return empRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name) {
        return empRepository.findByNameContaining(name);
    }

    //paging 
    @Override
    public List<Employee> getEmployee(int pageNumber, int pageSize) {
        Pageable pages =PageRequest.of(pageNumber, pageSize);
        return empRepository.findAll(pages).getContent();
    }
    
    //sorting
     @Override
    public List<Employee> getEmployeesSortByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        return empRepository.findByNameContaining(name,sort);
        
    }
    
    //paging and sorting
    @Override
    public List<Employee> getEmployeePagingAndSorting(int pageNumber, int pageSize) {
        Pageable pages =PageRequest.of(pageNumber, pageSize,Sort.Direction.DESC,"id","name");
        return empRepository.findAll(pages).getContent();
    }

    @Override
    public List<Employee> getEmployeeNameOrLocation(String name, String location) {
     return empRepository.getEmployeeByNameOrLocation(name, location);
    }
    

}
