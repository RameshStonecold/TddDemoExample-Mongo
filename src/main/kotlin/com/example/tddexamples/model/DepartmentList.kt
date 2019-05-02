package com.example.tddexamples.model

class DepartmentList {

    private var oldDeptList:List<Department>?=null
    constructor(oldDeptList: List<Department>){
        this.oldDeptList=oldDeptList
    }


 /*   fun updateDepartmentList(oldDeptList:List<Department>,newDeptList: List<Department>):List<Department>{

        newDeptList.forEach { x->

            if (oldDeptList!=null && newDeptList!=null) {

                val oldDeptMap = oldDeptList.associateBy({ it.getDepartmentId() }, { it })

                val oldDept = oldDeptMap.get(x.getDepartmentId())
                    oldDept?.setDepartmentId(x.getDepartmentId()!!)
                    oldDept?.setDeptName(x.getDeptName()!!)
                    oldDept?.setDeptUpdatedDate(x.getDeptUpdatedDate())
                    oldDept?.setSal(x.getSal()!!)
            }
        }
        return newDeptList
    }*/

    fun updateDepartmentList(newDeptList: List<Department>):List<Department>{

        newDeptList.forEach {
            x->
            if (oldDeptList!=null){
                val oldDeptMap = oldDeptList!!.associateBy({it.getDepartmentId()},{it})
                val oldDept =oldDeptMap.get(x.getDepartmentId())
                oldDept?.setDepartmentId(x.getDepartmentId()!!)
                oldDept?.setDeptName(x.getDeptName()!!)
                oldDept?.setSal(x.getSal()!!)
                oldDept?.setDeptUpdatedDate(x.getDeptUpdatedDate())
            }
        }
        return newDeptList
    }
}