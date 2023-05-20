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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>> getEmployeeList() {
        return new ResponseEntity<List<Employee>>(empService.getEmployee(), HttpStatus.OK);
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
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(empService.saveEmployee(employee), HttpStatus.CREATED);
    }

//    @GetMapping("/info/{id}")
//    public Employee getEmployeeInfo(@PathVariable Long id) {
//        return empService.getSingleEmployee(id);
//    }
    @GetMapping("/info/{id}")
    public ResponseEntity<Employee> getEmployeeInfo(@PathVariable Long id) {
        return new ResponseEntity<>(empService.getSingleEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/update/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        employee.setId(id);
//        return empService.updateEmployee(employee);
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(empService.updateEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/filterByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeesByKeyword(name), HttpStatus.OK);
    }

    //paging
    @GetMapping("/listPaging")
    public ResponseEntity<List<Employee>> getEmployeeListPaging(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(empService.getEmployee(pageNumber,pageSize), HttpStatus.OK);
    }
    
    //sorting
    @GetMapping("/filterBySortingKeyword")
    public ResponseEntity<List<Employee>> getEmployeeSortByKeyword(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeesByKeyword(name), HttpStatus.OK);
    }
    
    //paging and sorting
    @GetMapping("/listPagingAndSorting")
    public ResponseEntity<List<Employee>> getEmployeeListPageAndSort(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeePagingAndSorting(pageNumber,pageSize), HttpStatus.OK);
    }
    
    //query param 
    @GetMapping("/list/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeeEmployeeOrLocation(@PathVariable String name, @PathVariable String location) {
        return new ResponseEntity<List<Employee>>(empService.getEmployeeNameOrLocation(name, location), HttpStatus.OK);
    }
    

}
