package org.example.ems_new.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotBlank
    private String name;
    @Column(unique = true)
    @NotBlank
    private String email;
    @Column
    @NotBlank
    private String department;
    @Column
    @NotBlank
    private double salary;
}