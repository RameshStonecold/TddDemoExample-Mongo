package com.example.tddexamples.dto


import java.time.LocalDateTime

 class DepartmentDto {

         var deptId: String? = null
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