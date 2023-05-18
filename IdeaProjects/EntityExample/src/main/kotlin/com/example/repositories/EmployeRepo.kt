package com.example.repositories

import com.example.dbconfiguration.DatabaseConnection
import com.example.entities.employee
import com.example.entities.employeeBind
import com.example.models.Employee
import com.example.models.Employees
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.map
import me.liuwj.ktorm.dsl.select

class EmployeRepo {
    val data = DatabaseConnection.database
    suspend fun getemployee(): List<Employees> {
        return data.from(employee).select().map { row -> employeeBind.createEntity(row) }
    }
}