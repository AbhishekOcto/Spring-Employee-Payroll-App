package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @RequestMapping(value = {"","/","/get"}, method = RequestMethod.GET)
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get call success", HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("id") int id){
        return new ResponseEntity<>("Get call success for id : "+id,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("created employee payroll data for "+empPayrollDTO,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("updated employee payroll data for "+empPayrollDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("id") int id){
        return new ResponseEntity<String>("Delete call success for id "+id,HttpStatus.OK);
    }
}
