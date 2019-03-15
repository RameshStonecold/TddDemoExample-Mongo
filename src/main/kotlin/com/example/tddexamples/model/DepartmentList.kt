package com.example.tddexamples.model

class DepartmentList {


    fun updateDepartmentList(oldDeptList:List<Department>,newDeptList: List<Department>):List<Department>{

        newDeptList.forEach { x->

            if (oldDeptList!=null) {

                val oldDeptMap = oldDeptList.associateBy({ it.getDepartmentID() }, { it })

                val oldDept = oldDeptMap.get(x.getDepartmentID())

                if (oldDept?.getDepartmentID()!!.equals(x.getDepartmentID())) {
                    oldDept.setDeptName(x.getDeptName()!!)
                    oldDept.setDeptUpdatedDate(x.getDeptUpdatedDate())
                    oldDept.setSal(x.getSal()!!)
                }

            }
        }
        return newDeptList
    }
}