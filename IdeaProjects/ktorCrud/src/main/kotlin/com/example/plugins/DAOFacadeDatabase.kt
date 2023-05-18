package com.example.plugins

import com.example.Customer
import com.example.customers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction


class DAOFacadeDatabase(val db: Database): DAOFacade {
    override fun init() = transaction(db) {
        SchemaUtils.create(customers)
    }
    override fun createEmployee(firstName: String,lastName: String, mailId: String) = transaction(db) {
        customers.insert{it[customers.firstName] = firstName;
            it[customers.mailId] = mailId; it[customers.lastName] = lastName;
        }
        Unit
    }
    override fun updateEmployee(id: Int, name: String, email: String, city: String) = transaction(db) {
        customers.update({customers.id eq id}){
            it[customers.firstName] = firstName
            it[customers.mailId] = mailId
            it[customers.lastName] = lastName
        }
        Unit
    }
    override fun deleteEmployee(id: Int) = transaction(db) {
        customers.deleteWhere { customers.id eq id }
        Unit
    }
    override fun getEmployee(id: Int) = transaction(db) {
        customers.select { customers.id eq id }.map {
            Customer(it[customers.id], it[customers.firstName], it[customers.mailId], it[customers.lastName]
            )
        }.singleOrNull()
    }
    override fun getAllEmployees() = transaction(db) {
        customers.selectAll().map {
            Customer(it[customers.id], it[customers.firstName], it[customers.mailId], it[customers.lastName]
            )
        }
    }
    fun close() { }
}
