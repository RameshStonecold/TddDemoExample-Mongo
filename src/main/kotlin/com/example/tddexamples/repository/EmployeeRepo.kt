package com.example.tddexamples.repository

import com.example.tddexamples.model.EmployeeState
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Repository

@Repository
@EnableMongoRepositories
interface EmployeeRepo: MongoRepository<EmployeeState, String> {

    fun findByEmpId(employeeId:String):EmployeeState

}