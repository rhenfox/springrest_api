/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.restapi.service;

import com.aldrin.restapi.model.Employee;
import java.util.List;

/**
 *
 * @author ALDRIN
 */
public interface EmployeeService {
    
   public  List<Employee> getEmployee();
   
   
   Employee saveEmployee(Employee employee);

   
   Employee getSingleEmployee(Long id);
   
   void deleteEmployee(Long id);
   
   Employee updateEmployee(Employee employee);
}
