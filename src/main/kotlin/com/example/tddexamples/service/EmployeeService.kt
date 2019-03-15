package com.example.tddexamples.service

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.model.*
import com.example.tddexamples.repository.EmpRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList



@Service
class EmployeeService : IEmployeeService {


    @Autowired
    lateinit var empRepo: EmpRepo



    override fun saveEmp(employeeDto: EmployeeDto): String {

        var employee = EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)

        var EmpState=   employee.createEmployee(employee)

        empRepo.save(EmpState)

        return "EmployeeState inserted"

    }

    override fun getEmployeeWithId(employeeId: String): EmployeeDto? {

        var empState = empRepo.findById_id(employeeId)

       val emp= EmployeeDtoConverter.Converter.empBeanToEmpDto(empState)

        return emp
    }


     override fun updateEmployee(employeeDto: EmployeeDto,id:String): String {

         val oldEmpDto =this.getEmployeeWithId(id)

        val oldEmployeeBean= EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(oldEmpDto!!)

         val newemployee= EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)

         val newDeptDtoList=employeeDto.departmentDtoList?.toList()
         val newdeptStateList =EmployeeDtoConverter.Converter.convertSetOfDeptDtoToBean(newDeptDtoList!!)
         val newdeptList=newdeptStateList.stream().
                 map { x->Department(x as DepartmentState) }.toList()

         empRepo.save(oldEmployeeBean.updateEmployee(newemployee,newdeptList))

        return "updated"
    }


    override fun getAllEmps(): List<EmployeeDto> {
        var allEmps = empRepo.findAll()

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
