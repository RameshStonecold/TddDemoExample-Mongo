package com.example.tddexamples.controller

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.model.EmployeeState
import com.example.tddexamples.service.IEmployeeService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController("/emp")
@Api(value = "employeeController", description= "Rest API for New Center Request Report")

class EmployeeController {

    @Autowired
    lateinit var iEmployeeService:IEmployeeService


    @PostMapping("/saveEmployee")
    fun saveEmp(@RequestBody employeeDto: EmployeeDto) : String{

        iEmployeeService.saveEmp(employeeDto)

        return "EmployeeState updated"
    }

    @GetMapping("/getEmpById/{employeeId}")
    fun getEmployee(@PathVariable ("employeeId")employeeId: String): EmployeeDto?
    {
        var emp =iEmployeeService.getEmployeeWithId(employeeId)

        return emp
    }

/*
  @GetMapping("/getAllEmployees")
  fun getAllEmps():List<EmployeeDto>{

    return iEmployeeService.getAllEmps()

  }
*/

/*    @PutMapping("/updateEmployee")
    fun updateEmployee(@RequestBody employeeDto: EmployeeDto){

        iEmployeeService.updateEmployee(employeeDto)

    }

    @PutMapping("/updateDepartment/{departmentId}")
    fun updateDepartment(@RequestBody departmentDto: DepartmentDto,@PathVariable("departmentId")departmentId: String, @PathVariable("employeeId")employeeId: String)
    {
        iEmployeeService.updateDepartment(departmentDto,employeeId)

    }*/
}