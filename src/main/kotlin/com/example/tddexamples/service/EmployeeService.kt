package com.example.tddexamples.service

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.model.*
import com.example.tddexamples.repository.EmployeeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Arrays.stream
import kotlin.streams.toList
import java.util.stream.Collectors



@Service
class EmployeeService : IEmployeeService {


    @Autowired()
    lateinit var employeeRepo: EmployeeRepo



    override fun saveEmp(employeeDto: EmployeeDto): String {

        var employee = EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)

        var EmpState=   employee.createEmployee(employee)

        employeeRepo.save(EmpState)

        return "EmployeeState inserted"

    }

    override fun getEmployeeWithId(employeeId: String): EmployeeDto? {

        val empState = employeeRepo.findByEmpId(employeeId)

       val emp= EmployeeDtoConverter.Converter.empBeanToEmpDto(empState)

        return emp
    }


     override fun updateEmployee(employeeDto: EmployeeDto): String {

         val oldEmpDto =this.getEmployeeWithId(employeeDto.empId!!)

        val oldEmployeeBean= EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(oldEmpDto!!)

         val newemployee= EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)

         val newDeptDtoList=employeeDto.departmentDtoList?.toList()
         val newdeptStateList =EmployeeDtoConverter.Converter.convertSetOfDeptDtoToBean(newDeptDtoList!!)
         val newdeptList=newdeptStateList.stream().
                 map { x->Department(x as DepartmentState) }.toList()

       val newEmpState=  oldEmployeeBean.updateEmployee(newemployee,newdeptList)

         employeeRepo.save(newEmpState)

        return "updated"
    }


    override fun getAllEmps(): List<EmployeeDto> {
        var allEmps = employeeRepo.findAll()

        var empDtoList = EmployeeDtoConverter.Converter.convertEmpListToEmpDtoList(allEmps)
        return empDtoList
    }





 /* override fun updateDepartment(departmentDto: DepartmentDto, employeeId: String): String
    {

        var oldEmp= this.getEmployeeWithId(employeeId)
       var deptbean= EmployeeDtoConverter.Converter.convertDeptDtotoBean(departmentDto)
       var dept= oldEmp?.getDepartmentStateList()?.stream()?.
                filter { x->x.deptId.getId().compareTo(departmentDto.deptId)==0 }?.
                filter { x->x.updateDept(deptbean) }

        return "updated"
    }
*/


}
