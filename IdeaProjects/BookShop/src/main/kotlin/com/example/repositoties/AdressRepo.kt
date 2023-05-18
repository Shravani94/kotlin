package com.example.repositoties

import com.example.Model.AddressDTO
import com.example.databaseconfig.DatabaseFactory
import com.example.entities.Address
import com.example.entities.Addresses
import org.ktorm.dsl.*

interface AddressRepo {
    suspend fun saveAddress(params: AddressDTO): Int
    suspend fun getAddress():List<Address>
    suspend fun getAddressById(id:Int):List<AddressDTO>
}
class AddressRepository:AddressRepo{
    override suspend fun saveAddress(params: AddressDTO): Int {
        val dbConnection=DatabaseFactory.getConnection()
      return dbConnection.insert(Addresses){
            set(it.addid,params.addid)
            set(it.city,params.city)
            set(it.colony,params.colony)
            set(it.state,params.state)
            set(it.pincode,params.pincode)
        }
    }

    override suspend fun getAddress(): List<Address> {
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(Addresses).select()
            .map { row ->Addresses.createEntity(row)  } }

    }

    override suspend fun getAddressById(id: Int): List<AddressDTO> {
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(Addresses).select().map { row ->Addresses.createEntity(row) }.map { AddressDTO(it.addid,
            it.colony,
            it.city,
            it.state,
            it.pincode

        ) }}

    }

}