package com.example.tddexamples.model


import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import javax.persistence.Id

@Document
  class DepartmentState :IDepartment {
    @Id
    private var deptId:String?=null

    private var deptName: String?=null

    private var sal: String?=null

    private var deptCreatedDate: LocalDateTime = LocalDateTime.now()

    private var deptUpdatedDate: LocalDateTime = LocalDateTime.now()


    override fun getDeptId(): String? {
        return this.deptId

    }

    override fun setDeptId(deptId: String) {
        this.deptId=deptId
    }

    override fun getDeptName(): String? {
        return this.deptName

    }

    override fun setDeptName(deptName: String) {
        this.deptName=deptName
    }

    override fun getSal(): String? {
        return this.sal
    }

    override fun setSal(sal: String) {
        this.sal=sal

    }

    override fun getDeptCreatedDate(): LocalDateTime {
        return this.deptCreatedDate
    }

    override fun setDeptCreatedDate(deptCreatedDate: LocalDateTime) {
        this.deptUpdatedDate=deptCreatedDate
    }

    override fun getDeptUpdatedDate(): LocalDateTime {
        return this.deptUpdatedDate
    }

    override fun setDeptUpdatedDate(deptUpdatedDateTime: LocalDateTime) {
        this.deptUpdatedDate=deptUpdatedDate
    }









}
