package com.example.services

import com.example.entities.Student
import com.example.models.StudentDTO
import com.example.repositories.StudentRepository

class StudentService {
    private val studentRepo=StudentRepository()
    suspend fun saveStudentWithDepartment(param:StudentDTO):Int {
        return studentRepo.saveStudentWithDepartment(param)
    }
    suspend fun saveStudent(param: StudentDTO):Int{
        return studentRepo.saveStudent(param)
    }
    suspend fun getStudentWithDepartment():List<StudentDTO>{
        return studentRepo.getStudentWithDepartment()
    }
    suspend fun getStudents():List<Student>{
        return studentRepo.getStudents()
    }

}