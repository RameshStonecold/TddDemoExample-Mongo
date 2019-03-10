package com.example.tddexamples.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.*

@Document
 class EmployeeState:IEmployee {


    @Id
    private var empId: String? = null

    private var empName: String? = null

   private var empCreatedDate: LocalDateTime = LocalDateTime.now()

   private var empUpdatedDate: LocalDateTime = LocalDateTime.now()

   private var departmentStateSet= HashSet<Department>()

    override fun getEmpId(): String? {
        return this.empId
    }

    override fun setEmpId(empId: String) {
     this.empId=empId
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

    override fun getDepartmentStateSet(): HashSet<Department> {

       return departmentStateSet
    }

    override fun setDepartementSateSet(departmentSet: HashSet<Department>) {
        this.departmentStateSet=departmentSet
    }




}
