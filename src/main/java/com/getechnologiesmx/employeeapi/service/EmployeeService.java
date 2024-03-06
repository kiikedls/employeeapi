package com.getechnologiesmx.employeeapi.service;

import com.getechnologiesmx.employeeapi.entity.Employee;
import com.getechnologiesmx.employeeapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //enlistar todo
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //obtener uno
    public Employee findById(Integer id){
        return employeeRepository
                .findById(id)
                .orElse(null);
    }

    //crear
    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    //actualizar
    public Employee update(Integer id, Employee form){
        Employee employeeFromDb= findById(id);

        employeeFromDb.setName(form.getName());
        employeeFromDb.setBirthday(form.getBirthday());
        employeeFromDb.setAge(form.getAge());
        employeeFromDb.setCharge(form.getCharge());
        employeeFromDb.setStatus(form.getStatus());

        return employeeRepository.save(employeeFromDb);
    }

    //Borrar
    public void delete(Integer id){
        Employee employeeFromDb= findById(id);

        employeeRepository.delete(employeeFromDb);
    }
}
