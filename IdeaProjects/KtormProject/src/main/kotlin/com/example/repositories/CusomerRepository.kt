package com.example.repositories

import com.example.dbconfig.DatabaseConnection1
import com.example.entities.customers
import com.example.models.CustomerDTO
import org.ktorm.dsl.*

class CusomerRepository {
     val data=DatabaseConnection1.database
     fun saveCustomer(param:CustomerDTO){
         data.insert(customers){
            set(it.id,param.id)
            set(it.name,param.custName)
            set(it.mail,param.custMail)
            set(it.mobile,param.custMobile)
        }
        }
     fun getCustomer():List<CustomerDTO>{
         return data.from(customers).select().map {
                row->customers.createEntity(row)}.map{
                    CustomerDTO(it.id,it.custName,it.custMail,it.custMobile)
            }
            }
    suspend fun getById(param:Int):List<CustomerDTO>{
        return data.from(customers).select().where(customers.id eq param).map{row->customers.createEntity(row)
        }.map{
                CustomerDTO(it.id,it.custName,it.custMail,it.custMobile)
        }
    }
    fun update(param: CustomerDTO): Int {
        return data.update(customers){
            set(it.name,param.custName)
            set(it.mail,param.custMail)
            set(it.mobile,param.custMobile)
            where{ it.id eq param.id }
        }

    }
    fun delete(param: CustomerDTO):Int{
        return data.delete(customers){ customers.id eq it.id }
    }
}