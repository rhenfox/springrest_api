/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.restapi.controller;

import com.aldrin.restapi.model.Employee;
import com.aldrin.restapi.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ALDRIN
 */
@RestController //@RestController= @Controller+ @ResponseBody
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

//    @Value("${app.name}")
//    private String appName;
//
//    @Value("${app.version:version 1}")
//    private String appVersion;
//
//    @GetMapping("/version")
//    public String getAppDetails() {
//        return appName + " - " + appVersion;
//    }

//    @GetMapping("/list")
//    public String getEmployeeList(){
//        return "Displying the list of employee";
//    }
    @GetMapping("/list")
    public List<Employee> getEmployeeList() {
        return empService.getEmployee();
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable("id") Long id) {
        return "Fetching the employee details for the id:" + id;
    }

//    @DeleteMapping("/delete")
//    public String deleteEmployee(@RequestParam("id") Long id){
//        return "Deleting the employee details for the id "+id;
//    }
//    @PostMapping("/employees")
//    public String saveEmployee(@RequestBody Employee employee){
//       return "Saving the employee details to the database name="+employee.getName()+" age="+employee.getAge()+" location="+employee.getLocation();
//    }
    
//    @PutMapping("/update/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        System.out.println("updating the employee details for the id " + id);
//        return employee;
//    }

    @PostMapping("/add")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return empService.saveEmployee(employee);
    }


    @GetMapping("/info/{id}")
    public Employee getEmployeeInfo(@PathVariable Long id) {
        return empService.getSingleEmployee(id);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam Long id) {
        empService.deleteEmployee(id);
    }
    
        @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return empService.updateEmployee(employee);
    }

}
