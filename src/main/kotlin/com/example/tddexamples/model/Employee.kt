package com.example.tddexamples.model

import java.time.LocalDateTime


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

    override fun getDepartmentStateSet(): HashSet<Department> {
        return employeeState.getDepartmentStateSet()
    }

    override fun setDepartementSateSet(departmentSet: HashSet<Department>) {
        this.employeeState.setDepartementSateSet(departmentSet)
    }




    fun updateEmployee(employee: Employee) {
        this.employeeState.setEmpName(employee.getEmpName()!!)
        this.employeeState.setDepartementSateSet(employee.getDepartmentStateSet())

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