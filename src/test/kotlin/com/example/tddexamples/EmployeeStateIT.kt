package com.example.tddexamples

import com.example.tddexamples.dto.DepartmentDto
import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.model.idGenerators.DepartmentId
import com.example.tddexamples.model.idGenerators.EmployeeId
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
        var departmentId=DepartmentId()
        departmentId.setId("3a94ee05-5194-4413-9ece-601f14e13011")
        departmentDto.departmentId= departmentId

        departmentDto.deptName="ABC"
        departmentDto.sal= "1000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        val departmentDto2=DepartmentDto()
        var departmentId2=DepartmentId()
        departmentId2.setId("014a961a-5412-42ff-b585-4fa9f912d648")
        departmentDto2.departmentId= departmentId2
        departmentDto2.deptName="XYZ"
        departmentDto2.sal="2000"
        departmentDto2.deptCreatedDate= LocalDateTime.now()
        departmentDto2.deptUpdatedDate= LocalDateTime.now()


        var dtoList=ArrayList<DepartmentDto>()
        dtoList.add(departmentDto)
        dtoList.add(departmentDto2)

        var employeeDto=EmployeeDto()
        var employeeId=EmployeeId()
        employeeId.setId("5c8b9a595f0f517979b5987c")
        employeeDto.employeeId= employeeId
        employeeDto.empName="arun k"
        employeeDto.empCreatedDate=LocalDateTime.now()
        employeeDto.empUpdatedDate= LocalDateTime.now()
        employeeDto.departmentDtoList= dtoList

        var empDto= iEmployeeService.saveEmp(employeeDto)


        Assert.assertEquals("EmployeeState inserted",empDto)
    }


    @Test
    fun getAllEmployees()
    {

        var empList=iEmployeeService.getAllEmps()
        Assert.assertTrue(empList.isNotEmpty())

    }
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
        var departmentId=DepartmentId()
        departmentId.setId("3a94ee05-5194-4413-9ece-601f14e13011")
        departmentDto.departmentId= departmentId
        departmentDto.deptName="Mahesh Babu"
        departmentDto.sal= "900000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        val departmentDto2=DepartmentDto()
        var departmentId2=DepartmentId()
        departmentId2.setId("014a961a-5412-42ff-b585-4fa9f912d648")
        departmentDto2.departmentId= departmentId2
        departmentDto2.deptName="Kalyan Babu"
        departmentDto2.sal="180000"
        departmentDto2.deptCreatedDate= LocalDateTime.now()
        departmentDto2.deptUpdatedDate= LocalDateTime.now()


        val dtoList=ArrayList<DepartmentDto>()
        dtoList.add(departmentDto)
       dtoList.add(departmentDto2)


        val employeeDto=EmployeeDto()
        var employeeId=EmployeeId()
        employeeId.setId("5c8b9a595f0f517979b5987c")
        employeeDto.employeeId= employeeId
        employeeDto.empName="Ramesh Stonecold"
        employeeDto.empCreatedDate=LocalDateTime.now()
        employeeDto.empUpdatedDate= LocalDateTime.now()
        employeeDto.departmentDtoList= dtoList

        val emp=iEmployeeService.updateEmployee(employeeDto, employeeDto.employeeId.getId())

       Assert.assertEquals("updated",emp)

    }


    @Test
    fun updateDepartement()
    {

        var departmentDto=DepartmentDto()
        departmentDto.departmentId= DepartmentId()
        departmentDto.deptName="z"
        departmentDto.sal= "000"
        departmentDto.deptCreatedDate=LocalDateTime.now()
        departmentDto.deptUpdatedDate=LocalDateTime.now()

        var empId ="12345"

        //var result=iEmployeeService.updateDepartment(departmentDto,empId)
    }


}