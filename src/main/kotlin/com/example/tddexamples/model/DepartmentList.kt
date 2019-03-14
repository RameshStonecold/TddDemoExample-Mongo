package com.example.tddexamples.model

class DepartmentList {



  /*  private var departmentList:List<Department>?=null

    constructor(deptList:List<Department>)
    {
        this.departmentList=deptList
    }*/

    fun updateDepartmentList(oldDeptList:List<Department>,newDeptList: List<Department>){

        newDeptList.forEach { x->

            val oldDeptMap=oldDeptList.associateBy( { it.getDeptId() },{it})

            var oldDept= oldDeptMap.get(x.getDeptId())

            if (oldDept?.getDeptId().equals(x.getDeptId()))
            {
                x.setDeptName(oldDept?.getDeptName()!!)
                x.setDeptCreatedDate(oldDept.getDeptCreatedDate())
                x.setSal(oldDept.getSal()!!)
            }

        }

    }
}