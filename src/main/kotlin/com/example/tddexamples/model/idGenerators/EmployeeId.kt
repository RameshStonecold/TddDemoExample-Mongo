/*
package com.example.tddexamples.model.idGenerators

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
open class EmployeeId : Serializable{

    internal var id = UUID.randomUUID().toString()

    fun getId(): String {
        return id
    }
    fun setId(id: String) {
        this.id = id
    }
     fun generate(){
        this.id= UUID.randomUUID().toString()
    }

    override fun toString(): String {
        return "EmployeeId(id='$id')"
    }


}*/
