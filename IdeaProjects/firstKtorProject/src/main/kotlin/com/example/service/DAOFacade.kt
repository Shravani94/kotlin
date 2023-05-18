package com.example.service

import com.example.model.Customer

interface DAOFacade:Cloneable {
    fun init()
    fun createEmployee(firstName:String, lastName:String, mailId:String)
    fun updateEmployee(id:Int, firstName: String,lastName: String, email:String)
    fun deleteEmployee(id:Int)
    fun getEmployee(id:Int): Customer?
    fun getAllEmployees(): List<Customer>
}