package com.example.tddexamples.model

import com.example.tddexamples.model.idGenerators.DepartmentId
import java.time.LocalDateTime


class Department(private var departmentState: DepartmentState):IDepartment by departmentState {

    constructor():this(DepartmentState())


    override fun getDepartmentId(): DepartmentId? {
        return this.departmentState.getDepartmentId()
    }

    override fun setDepartmentId(deptId: DepartmentId) {
        this.departmentState.setDepartmentId(deptId)
    }

    override fun getDeptName(): String? {
        return this.departmentState.getDeptName()
    }

    override fun setDeptName(deptName: String) {

        this.departmentState.setDeptName(deptName)
    }

    override fun getSal(): String? {
        return departmentState.getSal()
    }

    override fun setSal(sal: String) {
        this.departmentState.setSal(sal)
    }

    override fun getDeptCreatedDate(): LocalDateTime {
        return departmentState.getDeptCreatedDate()
    }

    override fun setDeptCreatedDate(deptCreatedDate: LocalDateTime) {
        this.departmentState.setDeptCreatedDate(deptCreatedDate)
    }

    override fun getDeptUpdatedDate(): LocalDateTime {
        return departmentState.getDeptUpdatedDate()
    }

    override fun setDeptUpdatedDate(deptUpdatedDateTime: LocalDateTime) {
        this.departmentState.setDeptUpdatedDate(deptUpdatedDateTime)
    }

    fun update(department: Department) {
        this.departmentState.setDeptName(department.departmentState.getDeptName()!!)
        this.departmentState.setDeptUpdatedDate(department.departmentState.getDeptUpdatedDate())
        this.departmentState.setSal(department.departmentState.getSal()!!)

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
