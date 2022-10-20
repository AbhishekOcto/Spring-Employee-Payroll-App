package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@Data
public @ToString class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;
    @Pattern(regexp = "male|female", message =" Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern= "dd MM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent (message ="startDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "Profile Pic can not be empty")
    public String profilePic;
    @NotNull(message = "department should not be empty")
    public List<String> departments;
}
