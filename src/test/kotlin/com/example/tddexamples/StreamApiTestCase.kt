/*
package com.example.tddexamples

import com.example.tddexamples.service.IEmployeeService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.streams.toList

@RunWith(SpringRunner::class)
@SpringBootTest
class StreamApiTestCase {


    @Autowired
    lateinit var iEmployeeService: IEmployeeService

    @Test
    fun streamTest()
    {
       var all = iEmployeeService.getAllEmps()

      var obj=  all.stream().
              filter{ it.empId.equals("8e303673-f4bc-4425-89f9-3160fc6e08a6") }.findAny()

        if (obj.isPresent) {
            println(obj.get())
        }
        Assert.assertTrue(obj.isPresent)


    }


    @Test
    fun mapTest()
    {

        var all = iEmployeeService.getAllEmps()

        var al = iEmployeeService.getAllEmps().
                stream().map { x->x.empName?.startsWith("a")}.forEach { it }

        var al1 = iEmployeeService.getAllEmps().
                stream().map{it.departmentDtoSet.stream().map { it.deptName?.length>5 }}.forEach { it }


       var map= all.stream().
               toList().associateBy ({it},{it.departmentDtoSet} )


      //  println(map)
        //Assert.assertTrue(all.equals(""))
    }
}*/
