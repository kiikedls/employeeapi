package com.getechnologiesmx.employeeapi.service;

import com.getechnologiesmx.employeeapi.dto.EmployeeDTO;
import com.getechnologiesmx.employeeapi.entity.Employee;
import com.getechnologiesmx.employeeapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

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
    public Employee create(EmployeeDTO employeeDTO){
        Employee employee = mapper.map(employeeDTO, Employee.class);

        return employeeRepository.save(employee);
    }

    //actualizar
    public Employee update(Integer id, EmployeeDTO employeeDTO){
        Employee employeeFromDb= findById(id);
        //el metodo map realiza una transferencia de datos y toma como entradas dos cosas, la fuente de los datos y a donde los va a transferir
        mapper.map(employeeDTO, employeeFromDb);

        return employeeRepository.save(employeeFromDb);
    }

    //Borrar
    public void delete(Integer id){
        Employee employeeFromDb= findById(id);

        employeeRepository.delete(employeeFromDb);
    }
}
