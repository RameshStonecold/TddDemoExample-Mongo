package com.example.tddexamples.service

import com.example.tddexamples.dto.EmployeeDto
import com.example.tddexamples.dto.EmployeeDtoConverter
import com.example.tddexamples.model.Employee
import com.example.tddexamples.model.EmployeeState
import com.example.tddexamples.repository.EmployeeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

    override fun getEmployeeWithId(employeeId: String): EmployeeState? {
        var emp = employeeRepo.findByEmpId(employeeId)
        return emp
    }


     /* override fun updateEmployee(employeeDto: EmployeeDto): String {

          var allEmpDtos=this.getAllEmps()
          var allEmpsBeans =EmployeeDtoConverter.Converter.convertEmployeeDtoListToEmployeeList(allEmpDtos)

         var employee= EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)

          employee.updateEmployee()

          var employeeList=EmployeeList()
          employeeList.updateEmployee(employee)

         // employeeRepo.save()

         var oldempBean =this.getEmployeeWithId(employeeDto.empId!!)
         val oldEmpState=EmployeeDtoConverter.Converter.convertEmpDtoToEmpBean(employeeDto)
          val employee= Employee(oldEmpState)
          var empState= employee.updateEmployee(oldEmpState)
        employeeRepo.save(empState)

        return "updated"
    }


    override fun getAllEmps(): List<EmployeeDto> {
        var allEmps = employeeRepo.findAll()

        var empDtoList = EmployeeDtoConverter.Converter.convertEmpListToEmpDtoList(allEmps)
        return empDtoList
    }

*/




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
