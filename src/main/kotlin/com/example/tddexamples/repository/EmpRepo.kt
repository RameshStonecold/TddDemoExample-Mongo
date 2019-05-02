package com.example.tddexamples.repository

import com.example.tddexamples.model.EmployeeState
import com.example.tddexamples.model.idGenerators.EmployeeId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmpRepo : MongoRepository<EmployeeState,String> {

    @Query(value="{ 'id' : ?0 }")
    fun findById_id(id :String) :EmployeeState

}