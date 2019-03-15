package com.example.tddexamples.model

import java.time.LocalDateTime

interface IEmployee {

    fun getId():String?
    fun setId(empId:String)

    fun getEmpName():String?
    fun setEmpName(empName:String)

    fun getEmpCreatedDate():LocalDateTime
    fun setEmpCreatedDate(empCreatedDate:LocalDateTime)

    fun getEmpUpdatedDate():LocalDateTime
    fun setEmpUpdatedDate(empUpdatedDate:LocalDateTime)


    fun getDepartmentStateList():List<DepartmentState>?
    fun setDepartementStateList(departmentStateList:List<DepartmentState>)


}