package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    /*
     * This method is used to get the all the Employee payroll data from database
     * */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }
    /*
     * This method is used to get the Employee payroll data from database by id
     * */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee not found for id "+empId));
    }
    /*
     * This method takes one argument EmployeePayrollDTO and stores EmployeePayrollData in database
     * */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        employeePayrollRepository.save(employeePayrollData);
        return employeePayrollData;
    }

    /*
     * This method takes two arguments employee id and EmployeePayrollDTO
     * if data is present with given id then it will update and return updated employee data
     * */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findById(empId);
        if (employeePayrollData.isPresent()){
            EmployeePayrollData empData = employeePayrollData.get();
            empData.setName(empPayrollDTO.name);
            empData.setSalary(empPayrollDTO.salary);
            employeePayrollRepository.save(empData);
            return empData;
        }
        return null;
    }
    /*
     * This method takes one argument employee id
     * if record is present with given id then it will delete that record
     * */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId);
    }
}
