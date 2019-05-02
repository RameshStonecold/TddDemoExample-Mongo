package com.example.tddexamples.model

import java.time.LocalDateTime
import kotlin.streams.toList


class Employee(private var employeeState: EmployeeState): IEmployee by employeeState{


    constructor():this(EmployeeState())

    override fun getId(): String? {
       return this.employeeState.getId()
    }
    override fun setId(empId: String) {
        this.employeeState.setId(empId)
    }

    override fun getEmpName(): String? {
        return this.employeeState.getEmpName()
    }
    override fun setEmpName(empName: String) {
        this.employeeState.setEmpName(empName)
    }

    override fun getEmpCreatedDate(): LocalDateTime {
        return this.employeeState.getEmpCreatedDate()
    }

    override fun setEmpCreatedDate(empCreatedDate: LocalDateTime) {
        this.employeeState.setEmpCreatedDate(empCreatedDate)
    }

    override fun getEmpUpdatedDate(): LocalDateTime {
         return this.employeeState.getEmpUpdatedDate()
    }

    override fun setEmpUpdatedDate(empUpdatedDate: LocalDateTime) {
        this.employeeState.setEmpUpdatedDate(empUpdatedDate)
    }

    override fun getDepartmentStateList(): List<DepartmentState>? {
        return this.employeeState.getDepartmentStateList()
    }

    override fun setDepartementStateList(departmentStateList: List<DepartmentState>) {
        this.employeeState.setDepartementStateList(departmentStateList)
    }

    fun createEmployee(employee:Employee):EmployeeState{
        this.employeeState.setEmpName(employee.employeeState.getEmpName()!!)
        this.employeeState.setEmpCreatedDate(employee.employeeState.getEmpCreatedDate())
        this.employeeState.setDepartementStateList(employee.employeeState.getDepartmentStateList()!!)

        /*this.employeeState.getDepartmentStateList()?.
                map { x->Department(x as DepartmentState) }?.stream()?.
                forEach { y->y.create() }*/

        return this.employeeState
    }



    fun updateEmployee(employee: Employee,deptList:List<Department>) : EmployeeState
    {

       val oldDeptList= this.employeeState.
               getDepartmentStateList()?.stream()?.
               map {x->Department(x as DepartmentState)}?.toList()

        val departmentList =DepartmentList(oldDeptList!!)

       val newDeptList= departmentList.updateDepartmentList(deptList)


        val newDeptStateList =ArrayList<DepartmentState>()

        val departState =DepartmentState()
        newDeptList.forEach { x->

            departState.setDepartmentId(x.getDepartmentId()!!)
           departState.setDeptName(x.getDeptName()!!)
            departState.setSal(x.getSal()!!)
            departState.setDeptCreatedDate(x.getDeptCreatedDate())

        }
        newDeptStateList.add(departState)

        this.employeeState.setId(employee.getId()!!)
        this.employeeState.setEmpName(employee.getEmpName()!!)
        this.employeeState.setEmpUpdatedDate(employee.getEmpUpdatedDate())
        this.employeeState.setDepartementStateList(newDeptStateList)


        return employeeState
    }


    fun updateEmp(employee: Employee):EmployeeState{

        this.employeeState.setId(employee.employeeState.getId()!!)
        this.employeeState.setEmpName(employee.employeeState.getEmpName()!!)
        this.employeeState.setEmpCreatedDate(employee.employeeState.getEmpCreatedDate())
        this.employeeState.setEmpUpdatedDate(employee.employeeState.getEmpUpdatedDate())
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