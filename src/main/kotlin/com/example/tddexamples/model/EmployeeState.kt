package com.example.tddexamples.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.*



@Document
 class EmployeeState:IEmployee {

    @Id
    internal var id: String? = null

    private var empName: String? = null

    private var empCreatedDate: LocalDateTime = LocalDateTime.now()

    private var empUpdatedDate: LocalDateTime = LocalDateTime.now()

    private var departmentStateList:List<DepartmentState>?=null

    override fun getId(): String? {
        return this.id
    }

    override fun setId(empId: String) {
     this.id=empId
    }

    override fun getEmpName(): String? {
    return this.empName
    }

    override fun setEmpName(empName: String) {

        this.empName=empName
    }

    override fun getEmpCreatedDate(): LocalDateTime {
     return this.empCreatedDate
    }

    override fun setEmpCreatedDate(empCreatedDate: LocalDateTime) {
      this.empCreatedDate=empCreatedDate

    }

    override fun getEmpUpdatedDate(): LocalDateTime {

       return this.empUpdatedDate
    }

    override fun setEmpUpdatedDate(empUpdatedDate: LocalDateTime) {

       this.empUpdatedDate=empUpdatedDate

    }

    override fun getDepartmentStateList(): List<DepartmentState>? {
        return this.departmentStateList
    }

    override fun setDepartementStateList(departmentStateList: List<DepartmentState>) {

         this.departmentStateList=departmentStateList
    }




}
