package com.example.tddexamples

import com.example.tddexamples.dto.DepartmentDto
import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.model.Employee
import com.example.tddexamples.model.EmployeeList
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class EmployeeListTest {


    @Test
    fun updateTest(){

        var departmentDto= DepartmentDto()
        departmentDto.deptId="2345"
        departmentDto.deptName="AB"
        departmentDto.sal= "1000"
        departmentDto.deptCreatedDate= LocalDateTime.now()
        departmentDto.deptUpdatedDate= LocalDateTime.now()

        var dtoHashSet=HashSet<DepartmentDto>()
        dtoHashSet.add(departmentDto)

        var employeeDto= EmployeeDto()
        employeeDto.empId="23456"
        employeeDto.empName="arun k"
        employeeDto.empCreatedDate= LocalDateTime.now()
        employeeDto.empUpdatedDate= LocalDateTime.now()
        employeeDto.departmentDtoSet= dtoHashSet

      var empState=  EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)


        var employee1=Employee()
        employee1


//     Employee 2
        var departmentDto2=DepartmentDto()
        departmentDto2.deptId="12345"
        departmentDto2.deptName="ABc"
        departmentDto2.sal= "1000000"
        departmentDto2.deptCreatedDate=LocalDateTime.now()
        departmentDto2.deptUpdatedDate=LocalDateTime.now()

        var dtoHashSet2=HashSet<DepartmentDto>()
        dtoHashSet2.add(departmentDto2)

        var employeeDto2=EmployeeDto()
        employeeDto2.empId="1234"
        employeeDto2.empName="varun dhawan k"
        employeeDto2.empCreatedDate=LocalDateTime.now()
        employeeDto2.empUpdatedDate= LocalDateTime.now()
        employeeDto2.departmentDtoSet= dtoHashSet

        var empState2=  EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto2)
        var employee2=Employee()
        employee2.employeeState=empState2

        var empList= ArrayList<Employee>()
        empList.add(employee1)
        empList.add(employee2)


        var employeeList=EmployeeList(empList)

        employeeList.updateEmployee(empState2)


    }

}