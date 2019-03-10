package com.example.tddexamples.model

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime

interface IDepartment {

    fun getDeptId():String?
    fun setDeptId(deptId:String)

    fun getDeptName():String?
    fun setDeptName(deptName:String)

    fun getSal():String?
    fun setSal(sal :String)

    fun getDeptCreatedDate():LocalDateTime
    fun setDeptCreatedDate(deptCreatedDate: LocalDateTime)

    fun getDeptUpdatedDate():LocalDateTime
    fun setDeptUpdatedDate(deptUpdatedDateTime: LocalDateTime)
}