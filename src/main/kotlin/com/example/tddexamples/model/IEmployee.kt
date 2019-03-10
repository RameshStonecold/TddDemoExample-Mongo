package com.example.tddexamples.model

import java.time.LocalDateTime

interface IEmployee {

    fun getEmpId():String?
    fun setEmpId(empId:String)


    fun getEmpName():String?
    fun setEmpName(empName:String)

    fun getEmpCreatedDate():LocalDateTime
    fun setEmpCreatedDate(empCreatedDate:LocalDateTime)

    fun getEmpUpdatedDate():LocalDateTime
    fun setEmpUpdatedDate(empUpdatedDate:LocalDateTime)


    fun getDepartmentStateSet():HashSet<Department>
    fun setDepartementSateSet(departmentSet:HashSet<Department>)


}