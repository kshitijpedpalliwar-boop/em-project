package com.firstone.em_project;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/v1/")
public class EmController {

   // List<Employee> employees = new ArrayList<>();
   // EmployeeService employeeService= new EmployeeServiceImpl();
   // dependency injection
     @Autowired
     EmployeeService employeeService;
     

     @GetMapping("employees")
      public List<Employee> getAllEmployees() {
       return employeeService.readEmployees();
    /* List<Employee> employees = new ArrayList<>();
       Employee emp = new Employee();
       emp.setName("kshitij");
       employees.add(null);
       employees.add(emp);  
       return employees;*/

   }
      @PostMapping("employees")
      public String createEmployee(@RequestBody Employee employee) {
       // employees.add(employee);
       return employeeService.createEmployee(employee);
       // return "Employee saved successfully";
      }
      
      @DeleteMapping("employees/{id}")
      public String deleteEmployee(@PathVariable Long id) {  
         // employees.remove(id);
        if(employeeService.deleteEmployee(id)) 
           return "deleted successfully";
        return "not found";
         
      }

      @PutMapping("employees/{id}")
      public String putMethodName(@PathVariable long id, @RequestBody Employee employee) {
          return employeeService.updateEmployee(id, employee);
      }
    
}
