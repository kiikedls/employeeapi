package com.getechnologiesmx.employeeapi.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private LocalDate birthday;
    private Integer age;
    private Integer charge;
    private Boolean status;
}
