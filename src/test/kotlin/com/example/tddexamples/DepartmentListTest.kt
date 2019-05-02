package com.example.tddexamples

import com.example.tddexamples.dto.DepartmentDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.model.Department
import com.example.tddexamples.model.DepartmentList
import com.example.tddexamples.model.DepartmentState
import com.example.tddexamples.model.idGenerators.DepartmentId
import com.example.tddexamples.service.IEmployeeService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime
import kotlin.streams.toList

@RunWith(SpringRunner::class)
@SpringBootTest
class DepartmentListTest {


    @Autowired
    lateinit var iEmployeeService:IEmployeeService





    @Test
    fun updateDepartmentTest()
    {
        val departmentDto = DepartmentDto()
        departmentDto.departmentId.setId("014a961a-5412-42ff-b585-4fa9f912d648")
        departmentDto.deptName="ANR"
        departmentDto.sal="888888"
        departmentDto.deptUpdatedDate= LocalDateTime.now()

        val departmentDto2 = DepartmentDto()
        departmentDto2.departmentId.setId("")
        departmentDto2.deptName="NTR"

        var deptDtoList = listOf(departmentDto)
        val newDeptStateList =EmployeeDtoConverter.
                Converter.convertSetOfDeptDtoToBean(deptDtoList)
        val newDeptList= newDeptStateList.stream().
                map {x->Department(x as DepartmentState)}?.toList()



        val emp=  iEmployeeService.getEmployeeWithId("5c8b9a595f0f517979b5987c")
        var empState =EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(emp!!)
        val oldDeptList= empState.getDepartmentStateList()?.stream()?.
                map {x->Department(x as DepartmentState)}?.toList()


        var departmentList =DepartmentList(oldDeptList!!)

        if (newDeptList != null) {
            if (oldDeptList != null) {
                departmentList.updateDepartmentList(newDeptList)
            }
        }

    }
}