package com.digitech.springrestapi.controller;

import com.digitech.springrestapi.Exceptions.EmployeeNotFoundException;
import com.digitech.springrestapi.model.Employee;
import com.digitech.springrestapi.repository.EmployeeRepository;
import org.springframework.data.web.HateoasSortHandlerMethodArgumentResolver;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository employees){
        this.repository = employees;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee NewEmployee(@RequestBody Employee newEmployee){
            return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    EntityModel<Employee> GetEmployee(@PathVariable Long id){
        Employee employee =  repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).GetEmployee(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("employees"));
    }
    @PutMapping("/employees/{id}")
    Employee UpdateEmployee(@RequestBody Employee employee , @PathVariable Long id){
        Employee emp = new Employee();
        emp = repository.findById(id).orElseThrow();
        emp.setName(employee.getName());
        emp.setRole(employee.getRole());
        repository.save(emp);
        return emp;
    }

    @DeleteMapping("/employees/{id}")
    void DeleteEmployee(@PathVariable Long id){
         repository.deleteById(id);
    }
}
