package com.getechnologiesmx.employeeapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;
    @NonNull
    private LocalDate birthday;
    @NonNull
    private Integer age;
    @NonNull
    private Integer charge;
    @NonNull
    private Boolean status;
}
