package com.example.repositories

import DatabaseFactory
import com.example.entities.students
import com.example.model.StudentDTO
import org.ktorm.dsl.*

class StudentRepository {
    suspend fun insertStudent(param:StudentDTO):Int{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().insert(students){
                set(it.id,param.id)
                set(it.name,param.name)
                set(it.gender,param.gender)
                set(it.number,param.number)
                set(it.city,param.city)
                set(it.state,param.state)
                set(it.country,param.country)
                set(it.pincode,param.pincode)
            }
        }
    }
    suspend fun getAllStudents():List<StudentDTO>{
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(students).select().map { row -> students.createEntity(row) }.map { StudentDTO(
            it.id,
            it.name,
            it.gender,
            it.number,
            it.city,
            it.state,
            it.country,
            it.pincode
        )
        } }

    }
    suspend fun  getById(id:Int):List<StudentDTO>{
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(students).select().where(students.id eq id).map { row -> students.createEntity(row) }.map { StudentDTO(
            it.id,
            it.name,
            it.gender,
            it.number,
            it.city,
            it.state,
            it.country,
            it.pincode
        ) } }

    }
    suspend fun  getByName(name: String):List<StudentDTO>{
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(students).select().where(students.name eq name).map { row -> students.createEntity(row) }.map { StudentDTO(
            it.id,
            it.name,
            it.gender,
            it.number,
            it.city,
            it.state,
            it.country,
            it.pincode
        ) } }

    }

    suspend fun getByNameOrId(id:Int, name:String?):List<StudentDTO>?{
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().from(students).select().where{(students.id eq id)or(students.name eq name.toString())}.map { row -> students.createEntity(row) }.map { StudentDTO(
            it.id,
            it.name,
            it.gender,
            it.number,
            it.city,
            it.state,
            it.country,
            it.pincode
        ) } }


    }
    suspend fun updateByNameOrId(param:StudentDTO,id1:Int,name1:String): Int {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().update(students) {
                set(it.name, param.name)
                set(it.gender, param.gender)
                set(it.number, param.number)
                set(it.city, param.city)
                set(it.state, param.state)
                set(it.country, param.country)
                set(it.pincode, param.pincode)
                where {
                    (it.id eq id1) or (it.name eq name1)
                }
            }
        }
    }
    suspend fun updateByNameOrIdParam(param:StudentDTO,name:String,Id:Int): Int {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().update(students) {
                set(it.name, param.name)
                set(it.gender, param.gender)
                set(it.number, param.number)
                set(it.city, param.city)
                set(it.state, param.state)
                set(it.country, param.country)
                set(it.pincode, param.pincode)
                where {
                    (it.id eq Id) or (it.name eq name)
                }
            }
        }
    }
    suspend fun deleteById(param:StudentDTO):Int{
        return DatabaseFactory.dbQuery { DatabaseFactory.getConnection().delete(students){it.id eq param.id} }
    }
}
