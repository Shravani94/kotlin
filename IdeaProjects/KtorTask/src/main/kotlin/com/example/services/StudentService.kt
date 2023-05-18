package com.example.services

import com.example.model.StudentDTO
import com.example.repositories.StudentRepository

class StudentService {
    val studentRepo=StudentRepository()
    suspend fun insertStudent(param: StudentDTO):Int{
        return studentRepo.insertStudent(param)
    }
    suspend fun getAllStudents():List<StudentDTO>{
        return studentRepo.getAllStudents()
    }
    suspend fun getById(id:Int):List<StudentDTO>{
        return studentRepo.getById(id)
    }
    suspend fun getByIdOrName(id:Int, name:String?):List<StudentDTO>?{
        return studentRepo.getByNameOrId(id,name)
    }
    suspend fun updateByNameOrId(param: StudentDTO,id: Int,name: String):Int{
        return studentRepo.updateByNameOrId(param,id,name)
    }
    suspend fun getByName(name:String):List<StudentDTO>{
        return studentRepo.getByName(name)
    }
    suspend fun deleteById(param:StudentDTO):Int{
        return studentRepo.deleteById(param)
    }
    suspend fun updateByparam(param: StudentDTO,id:Int,name:String):Int{
        return studentRepo.updateByNameOrIdParam(param,name,id)
    }
}