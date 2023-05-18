package com.example.repositories

import com.example.dbconfig.DatabaseFactory
import com.example.entities.Departments
import com.example.models.DepartmentDTO
import org.ktorm.dsl.*

class DepartmentRepository {
    suspend fun saveDepartmentDetails(params:DepartmentDTO):Int{
            return DatabaseFactory.dbQuery{
                DatabaseFactory.getConnection().insert(Departments){
                    set(it.dept_no,params.dept_no)
                    set(it.dept_name,params.dept_name)
                    set(it.dept_head,params.dept_head)
                    set(it.no_faculty,params.no_faculty)
                }

                }
            }
    suspend fun getDepartments():List<DepartmentDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Departments).select()
                .map { row->Departments.createEntity(row) }.map { DepartmentDTO(
                    it.dept_no,
                    it.dept_name,
                    it.dept_head,
                    it.no_faculty
                )
                }
        }
    }
}
