package com.example.tddexamples

import com.example.tddexamples.dto.DepartmentDto
import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.service.IEmployeeService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class EmployeeStateIT {

    @Autowired
    lateinit var iEmployeeService: IEmployeeService


    @Test
    fun insertEmployee()
    {
        var departmentDto=DepartmentDto()
        departmentDto.deptId="12345"
        departmentDto.deptName="AB"
        departmentDto.sal= "1000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        var dtoList=ArrayList<DepartmentDto>()
        dtoList.add(departmentDto)

        var employeeDto=EmployeeDto()
        employeeDto.empId="1234"
        employeeDto.empName="arun k"
        employeeDto.empCreatedDate=LocalDateTime.now()
        employeeDto.empUpdatedDate= LocalDateTime.now()
        employeeDto.departmentDtoList= dtoList

        var empDto= iEmployeeService.saveEmp(employeeDto)


        Assert.assertEquals("EmployeeState inserted",empDto)
    }


/*    @Test
    fun getAllEmployees()
    {

        var empList=iEmployeeService.getAllEmps()
        Assert.assertTrue(empList.isNotEmpty())

    }*/
      @Test
       fun getByEmpById()
      {
           var id="12346789"

          var emp=iEmployeeService.getEmployeeWithId(id)

          Assert.assertNotNull(emp)
          println(emp.toString())
       }


    @Test
    fun updateEmployee()
    {
        val departmentDto=DepartmentDto()
        departmentDto.deptId="12345"
        departmentDto.deptName="z"
        departmentDto.sal= "2000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        val departmentDto2=DepartmentDto()
        departmentDto2.deptId="123450"
        departmentDto2.deptName="Y"
        departmentDto2.sal="1000"
        departmentDto2.deptCreatedDate= LocalDateTime.now()
        departmentDto2.deptUpdatedDate= LocalDateTime.now()


        val dtoList=ArrayList<DepartmentDto>()
        dtoList.add(departmentDto)
        dtoList.add(departmentDto2)


        val employeeDto=EmployeeDto()
        employeeDto.empId="12346789"
        employeeDto.empName="YYYY"
        employeeDto.empCreatedDate=LocalDateTime.now()
        employeeDto.empUpdatedDate= LocalDateTime.now()
        employeeDto.departmentDtoList= dtoList

        val emp=iEmployeeService.updateEmployee(employeeDto)

       Assert.assertEquals("updated",emp)

    }
    @Test
    fun updateDepartement()
    {

        var departmentDto=DepartmentDto()
        departmentDto.deptId="1234"
        departmentDto.deptName="z"
        departmentDto.sal= "000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        var empId ="12345"

        //var result=iEmployeeService.updateDepartment(departmentDto,empId)
    }


}