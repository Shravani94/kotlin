package com.example.services

import com.example.models.CustomerDTO
import com.example.repositories.CusomerRepository

class CustomerService {
    private val customerRepo=CusomerRepository()
    suspend fun saveCustomer(params: CustomerDTO) {
        return customerRepo.saveCustomer(params)
    }

    suspend fun getCustomers(): List<CustomerDTO> {
        return customerRepo.getCustomer()
    }
    suspend fun getById(param:Int):List<CustomerDTO>{
        return customerRepo.getById(param)
    }
    suspend fun updateById(param:CustomerDTO): Int {
        return customerRepo.update(param)
    }
    suspend fun delete(param:CustomerDTO):Int{
        return customerRepo.delete(param)
    }
}