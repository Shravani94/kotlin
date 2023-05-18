package com.example.routers

import com.example.Model.AddressDTO
import com.example.services.AddressService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.AddresssRouter(){
    val addressService=AddressService()
    routing {
        route("/address"){
            post("/addAddress") {
                val address=call.receive<AddressDTO>()
                val rowsAffected=addressService.saveAddress(address)
                if(rowsAffected>0){
                    call.respondText("inserted successfully")
                }else{
                    call.respondText("insertion failed")
                }
            }
            get("/address"){
                val addresslist=addressService.getAddresss()
                call.respond(addresslist)
            }
            get("/addressDtos/{id}") {
                val ids=Integer.parseInt(call.parameters["id"])
                val address=addressService.getAddressDto(ids)
                call.respond(address)
            }
        }
    }
}