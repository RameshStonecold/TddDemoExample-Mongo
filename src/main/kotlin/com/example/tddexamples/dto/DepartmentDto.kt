package com.example.tddexamples.dto


import com.example.tddexamples.model.idGenerators.DepartmentId
import java.time.LocalDateTime

 class DepartmentDto {

         var departmentId=DepartmentId()
                 get() = field
                 set(value) {
                         field = value
                 }
         var deptName: String?=null
                 get() = field
                 set(value) {
                         field = value
                 }
         var sal: String?=null
                 get() = field
                 set(value) {
                         field = value
                 }

         var deptCreatedDate: LocalDateTime = LocalDateTime.now()
                 get() = field
                 set(value) {
                         field = value
                 }

         var deptUpdatedDate: LocalDateTime = LocalDateTime.now()
                 get() = field
                 set(value) {
                         field = value
                 }


 }