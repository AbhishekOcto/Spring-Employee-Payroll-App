package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDTO {
    private int id;
    private String name;

    public EmployeePayrollDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return " id = " + id + ", name = " + name;
    }
}
