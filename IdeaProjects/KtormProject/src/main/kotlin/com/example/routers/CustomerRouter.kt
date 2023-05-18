package com.example.routers

import com.example.dbconfig.DatabaseConnection1.database
import com.example.models.CustomerDTO
import com.example.services.CustomerService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.customerRouting() {
    val customerService = CustomerService()
    routing {
        route("/customer") {
                    post("/insert") {
                        val param = call.receive<CustomerDTO>()
                        print(param)
                        val noOfrowsAffected = customerService.saveCustomer(param)
                        if (noOfrowsAffected.equals(0))
                            call.respond("Something wrong...!")
                        else
                            call.respond(param)
                    }
                }
            get("/showAllCustomers"){
                val customers=customerService.getCustomers();
                call.respond(customers)
            }
            get("/showById"){
                val customer=call.receive<CustomerDTO>()
                val customers=customerService.getById(customer.id)
                call.respond(customers)
            }
            get("/update"){
                val obj=call.receive<CustomerDTO>()
                val result=customerService.updateById(obj)
                if(result>0)
                    call.respond("updated successfully")
                else
                    call.respond("not updated")
            }
            delete("/remove"){
                val obj=call.receive<CustomerDTO>()
                val result=customerService.delete(obj)
                if(result>0)
                    call.respond("deleted successfully")
                else
                    call.respond("delete operation failed")
            }
        }
    }


