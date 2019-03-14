package com.example.tddexamples.repository

import com.example.tddexamples.model.EmployeeState
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepo: MongoRepository<EmployeeState, String> {

    @Query(value="{ 'empId' : ?0 }")
    fun findByEmpId(empId: String):EmployeeState

}