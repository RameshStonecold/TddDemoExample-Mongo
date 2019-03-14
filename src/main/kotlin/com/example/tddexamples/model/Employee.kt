package com.example.tddexamples.model

import java.time.LocalDateTime
import kotlin.streams.toList


class Employee(private var employeeState: EmployeeState): IEmployee by employeeState{


    constructor():this(EmployeeState())


    override fun getEmpId(): String? {
       return employeeState.getEmpId()
    }

    override fun setEmpId(empId: String) {
        this.employeeState.setEmpId(empId)
    }

    override fun getEmpName(): String? {
        return employeeState.getEmpName()
    }

    override fun setEmpName(empName: String) {

        this.employeeState.setEmpName(empName)
    }

    override fun getEmpCreatedDate(): LocalDateTime {

        return employeeState.getEmpCreatedDate()
    }

    override fun setEmpCreatedDate(empCreatedDate: LocalDateTime) {
        this.employeeState.setEmpCreatedDate(empCreatedDate)
    }

    override fun getEmpUpdatedDate(): LocalDateTime {
         return employeeState.getEmpUpdatedDate()

    }

    override fun setEmpUpdatedDate(empUpdatedDate: LocalDateTime) {
        this.employeeState.setEmpUpdatedDate(empUpdatedDate)
    }

    override fun getDepartmentStateList(): List<DepartmentState>? {
        return employeeState.getDepartmentStateList()
    }

    override fun setDepartementStateList(departmentStateList: List<DepartmentState>) {
        this.employeeState.setDepartementStateList(departmentStateList)
    }

    fun createEmployee(employee:Employee):EmployeeState{
        this.employeeState.setEmpId(employee.employeeState.getEmpId()!!)
        this.employeeState.setEmpName(employee.employeeState.getEmpName()!!)
        this.employeeState.setEmpCreatedDate(employee.employeeState.getEmpCreatedDate())
        this.employeeState.setDepartementStateList(employee.employeeState.getDepartmentStateList()!!)
        /*this.employeeState.getDepartmentStateList()?.
                map { x->Department(x as DepartmentState) }?.stream()?.
                forEach { y->y.create() }*/

        return this.employeeState
    }



    fun updateEmployee(employee: Employee,deptList:List<Department>) : EmployeeState{

        this.employeeState.setEmpName(employee.getEmpName()!!)
        this.employeeState.setEmpUpdatedDate(employee.getEmpUpdatedDate())

       val oldDeptList= this.employeeState.
               getDepartmentStateList()?.stream()?.
               map {x->Department(x as DepartmentState)}?.toList()

        val departmentList =DepartmentList()
        departmentList.updateDepartmentList(oldDeptList!!,deptList)

        return employeeState
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}