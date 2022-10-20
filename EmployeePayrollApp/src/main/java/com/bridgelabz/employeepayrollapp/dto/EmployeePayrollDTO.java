package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
public @ToString class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    public String gender;

    public String startDate;
    public String note;
    public String profilePic;
    public List<String> departments;
}
