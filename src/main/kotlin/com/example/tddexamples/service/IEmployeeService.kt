package com.example.tddexamples.service

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.model.EmployeeState


interface IEmployeeService {
    fun saveEmp(employeeDto: EmployeeDto): String

    fun getEmployeeWithId(employeeId: String): EmployeeState?

   /*   fun updateEmployee(employeeDto: EmployeeDto):String

    fun getAllEmps():List<EmployeeDto>*/

   // fun updateEmployee(employeeList:EmployeeList):String



   // fun updateDepartment(departmentDto: DepartmentDto, employeeId: String):String
}