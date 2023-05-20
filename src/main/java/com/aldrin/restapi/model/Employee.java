/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author ALDRIN
 */
 @Getter
 @Setter
 @ToString
 @Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @JsonProperty("full_name")
    
//    @NotNull(message ="Name should not be null")
    @NotBlank(message ="Name should not be null")
    private String name;
//    @JsonIgnore
    private Long age =0L;
    private String location;
    @Email(message="Email should not be null")
    private String email;
    @NotNull(message ="Department should not be null")
    private String department;
    @CreationTimestamp
    @Column(name="create_at", nullable=false,updatable=false)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_at")
    private Date updateAt;
    
}
