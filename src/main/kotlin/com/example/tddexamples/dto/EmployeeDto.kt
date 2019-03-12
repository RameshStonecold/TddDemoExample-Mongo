package com.example.tddexamples.dto



import java.time.LocalDateTime

 class EmployeeDto {

         var empId: String? = null
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
