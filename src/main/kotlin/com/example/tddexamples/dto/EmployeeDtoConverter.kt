package com.example.tddexamples.dto

import com.example.tddexamples.model.DepartmentState
import com.example.tddexamples.model.Employee
import com.example.tddexamples.model.EmployeeState
import org.springframework.beans.BeanUtils
import kotlin.collections.ArrayList

class EmployeeDtoConverter {

    object Converter{

        fun convertEmployeeDtoListToEmployeeList(empDtoList:List<EmployeeDto>):List<Employee>
        {
            val empList= ArrayList<Employee>()
            empDtoList.forEach { x->empList.add(this.convertEmpDtoToEmpBean(x)) }
            return empList
        }

        fun convertEmpDtoToEmpBean(employeeDto: EmployeeDto): Employee
        {

            var deptSet=this.convertSetOfDeptDtoToBean(employeeDto.departmentDtoList!!)

            val employeeState=EmployeeState()

            BeanUtils.copyProperties(employeeDto,employeeState)

            if(employeeDto.departmentDtoList != null)
            {
                val list =ArrayList<DepartmentState>()

                 employeeDto.departmentDtoList?.
                         forEach { x->list.
                                 add(EmployeeDtoConverter.Converter.convertDeptDtotoBean(x))}

                employeeState.setDepartementStateList(list)

            }

            return Employee(employeeState)
        }

        fun convertSetOfDeptDtoToBean(deptDtoList:List<DepartmentDto>) :ArrayList<DepartmentState>
        {
            val deptList= ArrayList<DepartmentState>()

            deptDtoList.forEach {x -> deptList.add(this.convertDeptDtotoBean(x))}

            return deptList
        }

        fun convertDeptDtotoBean(departmentDto: DepartmentDto) : DepartmentState
        {

            val departmentState =DepartmentState()

            BeanUtils.copyProperties(departmentDto,departmentState)

            return departmentState
        }



        //bean to dto



        fun convertEmpListToEmpDtoList(empList:List<EmployeeState>):List<EmployeeDto>
        {

            val employeeDtoList = ArrayList<EmployeeDto>()
            empList.forEach { x->employeeDtoList.add(this.empBeanToEmpDto(x)) }

            return employeeDtoList

        }

        fun empBeanToEmpDto(employeeState: EmployeeState): EmployeeDto {

            var employeeDto =EmployeeDto()

            BeanUtils.copyProperties(employeeState,employeeDto)

            var departmentDtoSet=EmployeeDtoConverter.Converter.convertSetOfDeptBeanToDto(employeeState.getDepartmentStateList()!!)


            return employeeDto
        }

        fun convertSetOfDeptBeanToDto(deptList: List<DepartmentState>):List<DepartmentDto>
        {
            var deptDtoList=ArrayList<DepartmentDto>()

            deptList.forEach { x->deptDtoList.add(this.convertDeptBeanToDeptDto(x)) }

            return deptDtoList
        }

        fun convertDeptBeanToDeptDto(departmentState: DepartmentState):DepartmentDto
        {

            var departmentDto=DepartmentDto()

            BeanUtils.copyProperties(departmentState,departmentDto)

            return departmentDto
        }

    }
}
