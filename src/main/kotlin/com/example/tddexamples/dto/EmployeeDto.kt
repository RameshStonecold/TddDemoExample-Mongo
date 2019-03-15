package com.example.tddexamples.dto


import com.example.tddexamples.model.idGenerators.EmployeeId
import java.time.LocalDateTime
import java.util.*

class EmployeeDto {

         var employeeId=EmployeeId()
                 get() = field
                 set(value) {
                         field = value
                 }
         var empName: String?=null
                 get() = field
                 set(value) {
                         field = value
                 }
         var empCreatedDate: LocalDateTime = LocalDateTime.now()
                 get() = field
                 set(value) {
                         field = value
                 }
         var empUpdatedDate: LocalDateTime = LocalDateTime.now()
                 get() = field
                 set(value) {
                         field = value
                 }
         var departmentDtoList:List<DepartmentDto>?=null
                 get() = field
                 set(value) {
                         field = value
                 }
 }
