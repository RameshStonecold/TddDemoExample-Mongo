package com.example.tddexamples.model



class EmployeeList {



    var employees:List<Employee>?=null

    constructor(employees: List<Employee>?) {
        this.employees = employees
    }

    constructor()

    fun updateEmployee(employee: Employee) {

      var oldEmployee=   employees?.
              filter { it.getEmpId().equals(employee.getEmpId()) }!!. firstOrNull()
        if(oldEmployee==null){
            System.out.println("Exception")
        }
       oldEmployee?.updateEmployee(employee)

    }





}
