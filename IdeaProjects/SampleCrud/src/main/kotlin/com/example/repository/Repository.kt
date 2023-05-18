package com.example.repository

import com.example.dataclass.Employee
import org.ktorm.schema.Column

interface Repository {
    fun getAllEmployees():List<Employee>
    fun getEmployeeById(empId:Column<Int>):List<Employee>
    fun updateEmployee(empId:Column<Int>):List<Employee>
    fun deleteEmployee(empId:Column<Int>):List<Employee>
}