package com.example.tddexamples.model

import com.example.tddexamples.model.idGenerators.DepartmentId
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime

interface IDepartment {

    fun getDepartmentId(): DepartmentId?
    fun setDepartmentId(deptId:DepartmentId)

    fun getDeptName():String?
    fun setDeptName(deptName:String)

    fun getSal():String?
    fun setSal(sal :String)

    fun getDeptCreatedDate():LocalDateTime
    fun setDeptCreatedDate(deptCreatedDate: LocalDateTime)

    fun getDeptUpdatedDate():LocalDateTime
    fun setDeptUpdatedDate(deptUpdatedDateTime: LocalDateTime)
}