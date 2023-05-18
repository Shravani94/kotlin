package com.example.services

import com.example.models.DepartmentDTO
import com.example.repositories.DepartmentRepository

class DepartmentService {
    private val departmentRepo=DepartmentRepository()
    suspend fun saveDepartments(params:DepartmentDTO):Int{
        return departmentRepo.saveDepartmentDetails(params)
    }
    suspend fun getDepartment():List<DepartmentDTO>{
        return departmentRepo.getDepartments()
    }
}