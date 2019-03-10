/*
package com.example.tddexamples.model.idGenerators

import lombok.ToString
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class DepartmentId : Serializable{
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
        return "DepartmentId(id='$id')"
    }


}*/
