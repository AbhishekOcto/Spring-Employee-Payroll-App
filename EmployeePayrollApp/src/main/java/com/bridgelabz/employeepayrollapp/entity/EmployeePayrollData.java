package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity //@Entity Annotation tells Hibernate to create a table out of the Employee Payroll Class
@Table (name = "employee_payroll") //@Table specifies the mapped Table in DB
public @Data class EmployeePayrollData {
    @Id   //Specifies the primary key and id generation is set to auto
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id") //@Column Specifies the mapped Column Name in the DB. By default is the var name
    private int employeeId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    /*@ElementCollection and @CollectionTable is required for One to Many relationship*/
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }

}
// @ElementCollection for the persistence provider like Hibernate to persist the
//        elements of the Collection in an additional database table without creating an Entity
//        Class.
//• One Major Drawback – The elements of the collection have no id and Hibernate can’t
//        address them individually. Need to handle this drawback refer JPA One to Many
//        Mappings.
//        • The drawback is addressed by specifying the configuration for this table using the
//@CollectionTable annotation.
//        • The @CollectionTable annotation is used to specify the Table Name that stores all the
//        records of the collection, and the @JoinColumn that refers to the primary table.
