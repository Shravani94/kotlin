package com.example.repository

import com.example.databaseconnection.DatabaseConnecetion
import com.example.dataclass.Employee
import com.example.entitybinding.employees
import org.ktorm.schema.Column

class SubRepository:Repository {
    val db = DatabaseConnecetion.database
    override fun getAllEmployees(): List<Employee> {
    }

    override fun getEmployeeById(empId: Column<Int>): List<Employee> {
        val getEmployeeById = db.from(employees).joinReferencesAndSelect().
        map { row -> employees.createEntity(row)}
        return getEmployeeById
    }

    override fun updateEmployee(empId: Column<Int>): List<Employee> {
    }

    override fun deleteEmployee(empId: Column<Int>): List<Employee> {
    }
}