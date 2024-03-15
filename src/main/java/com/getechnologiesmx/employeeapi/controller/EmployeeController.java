package com.getechnologiesmx.employeeapi.controller;

import com.getechnologiesmx.employeeapi.dto.EmployeeDTO;
import com.getechnologiesmx.employeeapi.entity.Employee;
import com.getechnologiesmx.employeeapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> list() {
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public Employee get(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@RequestBody EmployeeDTO employeeDTO){
        //employee.setBirthday(LocalDate.now());
        return employeeService.create(employeeDTO);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable Integer id,
                           @RequestBody EmployeeDTO employeeDTO){
        return employeeService.update(id, employeeDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        employeeService.delete(id);
    }
}
