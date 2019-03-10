/*
package com.example.tddexamples;

import com.example.tddexamples.dto.EmployeeDto;
import com.example.tddexamples.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApiTestCaseJava {

    @Autowired
    private IEmployeeService iEmployeeService;



    @Test
    public void mapTest()
    {

       List<EmployeeDto> list= iEmployeeService.getAllEmps();

       list.stream().filter(x->x.getEmpId().
               equals("8e303673-f4bc-4425-89f9-3160fc6e08a6")).
               collect(Collectors.toList());

       
    }

}
*/
