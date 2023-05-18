package com.example.services

import com.example.Model.AddressDTO
import com.example.entities.Address
import com.example.repositoties.AddressRepository

class AddressService {
    val addressRepo=AddressRepository()
    suspend fun saveAddress(params:AddressDTO):Int{
        return addressRepo.saveAddress(params)
    }
    suspend fun getAddresss():List<Address>{
        return addressRepo.getAddress()
    }
    suspend fun getAddressDto(id:Int):List<AddressDTO>{
        return addressRepo.getAddressById(id)
    }
}