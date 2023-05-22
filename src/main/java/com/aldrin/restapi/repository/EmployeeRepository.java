/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.restapi.repository;

import com.aldrin.restapi.model.Employee;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ALDRIN
 */
@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
//  Select * from table_name where  name ='Aldrin Cabusog'

    List<Employee> findByName(String name);

//  Select * from table_name where  name ='Aldrin Cabusog'
    List<Employee> findByNameAndLocation(String name, String location);

//  select * from table_name where name LIKE "%Aldrin%"
//  use containing method  
    List<Employee> findByNameContaining(String keyword);

//  sorting of data    
    List<Employee> findByNameContaining(String keyword, Sort sort);

//  create query ep37
//    @Query("FROM employee WHERE name = :name OR location = :location")
    @Query("SELECT e FROM Employee e WHERE e.name = :name OR e.location = :location")
    List<Employee> getEmployeeByNameOrLocation(@Param("name") String name, @Param("location") String location);
    
    
// delete query
// keyword should uppercase
// table always has allias 
// set tablename first letter uppercase  
    @Transactional
    @Modifying
    @Query("DELETE FROM Employee e WHERE e.name =:name")
    Integer deleteEmployeeByName(@Param("name")String name);
    
    List<Employee> findByDepartmentName(String name);
    
    @Query("FROM Employee  WHERE department.name = :name")
    List<Employee> getEmployeeByDeptName(String name);
    
    
    
}


