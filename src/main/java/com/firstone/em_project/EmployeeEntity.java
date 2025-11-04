package com.firstone.em_project;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EM_db")
public class EmployeeEntity {

   @jakarta.persistence.Id
   @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
   private Long id;

   private String name;
   private String phone;
   private String email;
}