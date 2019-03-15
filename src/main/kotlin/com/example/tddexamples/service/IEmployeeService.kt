package com.example.tddexamples.service

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.model.EmployeeState


interface IEmployeeService {
    fun saveEmp(employeeDto: EmployeeDto): String

    fun getEmployeeWithId(employeeId: String): EmployeeDto?

    fun updateEmployee(employeeDto: EmployeeDto, id: String):String

    fun getAllEmps():List<EmployeeDto>


}