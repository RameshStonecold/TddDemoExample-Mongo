package com.example.tddexamples.dto

import com.example.tddexamples.model.DepartmentState
import com.example.tddexamples.model.EmployeeState
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class EmployeeDtoConverter {

    object Converter{

        fun convertEmployeeDtoListToEmployeeList(empDtoList:List<EmployeeDto>):List<EmployeeState>
        {
            val empList= ArrayList<EmployeeState>()
            empDtoList.forEach { x->empList.add(this.convertEmpDtoToEmpBean(x)) }
            return empList
        }

        fun convertEmpDtoToEmpBean(employeeDto: EmployeeDto): EmployeeState
        {

            var deptSet=this.convertSetOfDeptDtoToBean(employeeDto.departmentDtoSet)

            var employeeState=EmployeeState()
            employeeState.empId=employeeDto.empId
            employeeState.empName=employeeDto.empName
            employeeState.empCreatedDate=employeeDto.empCreatedDate
            employeeState.empUpdatedDate=employeeDto.empUpdatedDate
            employeeState.departmentStateSet=deptSet



            return employeeState
        }

        fun convertSetOfDeptDtoToBean(deptDtoSet:HashSet<DepartmentDto>) :HashSet<DepartmentState>
        {
            val deptSet= HashSet<DepartmentState>()

            deptDtoSet.forEach {x -> deptSet.add(this.convertDeptDtotoBean(x))}

            return deptSet
        }

        fun convertDeptDtotoBean(departmentDto: DepartmentDto) : DepartmentState
        {

            var departmentState =DepartmentState()
            departmentState.deptId=departmentDto.deptId
            departmentState.deptName=departmentDto.deptName
            departmentState.deptCreatedDate=departmentDto.deptCreatedDate
            departmentState.deptUpdatedDate=departmentDto.deptUpdatedDate



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

            var departmentDtoSet=EmployeeDtoConverter.Converter.convertSetOfDeptBeanToDto(employeeState.departmentStateSet)

            var employeeDto =EmployeeDto()
              employeeDto.empId=employeeState.empId
            employeeDto.empName= employeeState.empName!!
            employeeDto.empCreatedDate=employeeState.empCreatedDate
            employeeDto.empUpdatedDate=employeeState.empUpdatedDate
            employeeDto.departmentDtoSet=departmentDtoSet



            return employeeDto
        }

        fun convertSetOfDeptBeanToDto(deptSet: Set<DepartmentState>):HashSet<DepartmentDto>
        {
            var deptDtoSet=HashSet<DepartmentDto>()

            deptSet.forEach { x->deptDtoSet.add(this.convertDeptBeanToDeptDto(x)) }

            return deptDtoSet
        }

        fun convertDeptBeanToDeptDto(departmentState: DepartmentState):DepartmentDto
        {

            var departmentDto=DepartmentDto()
            departmentDto.deptId=departmentState.deptId
            departmentDto.deptName= departmentState.deptName!!
            departmentDto.deptCreatedDate=departmentState.deptCreatedDate
            departmentDto.deptUpdatedDate=departmentState.deptUpdatedDate
            departmentDto.sal= departmentState.sal!!

            return departmentDto
        }

    }
}
