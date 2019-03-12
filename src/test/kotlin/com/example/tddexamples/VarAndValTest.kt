package com.example.tddexamples

import org.junit.Assert
import org.junit.Test
import kotlin.collections.ArrayList

class VarAndValTest {

    @Test
    fun varTest(){

        val obj1=Any()
        obj1.hashCode()
        val obj2=Any()

        val list= ArrayList<Any>()
        list.add(obj1)
        list.add(obj2)
        list.add("123")

        println(list)
        Assert.assertEquals(list.any(),list)

    }
}