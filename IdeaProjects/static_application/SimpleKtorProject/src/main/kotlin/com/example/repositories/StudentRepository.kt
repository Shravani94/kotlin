package com.example.repositories

import com.example.dbconfig.DatabaseFactory
import com.example.entities.Departments
import com.example.entities.Student
import com.example.entities.Students
import com.example.models.DepartmentDTO
import com.example.models.StudentDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class StudentRepository {
    /*------------------save student--------------------------------------------*/
    suspend fun saveStudent(param:StudentDTO):Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        noOfRecordsAffected = dbConnection.insert(Students) {
            set(it.dept_id, param.dept_no)
            set(it.first_name, param.first_name)
            set(it.last_name, param.last_name)
            set(it.mail_id, param.mail_id)
            set(it.roll_no, param.roll_no)
        }
        transaction.commit()
        return noOfRecordsAffected
    }

    /*__________________________save student with department____________________*/
    suspend fun saveStudentWithDepartment(param: StudentDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if(shouldRollback(param)){
                dbConnection.insert(Departments){
                    set(it.dept_no,param.department.dept_no)
                    set(it.dept_name,param.department.dept_name)
                    set(it.dept_head,param.department.dept_head)
                    set(it.no_faculty,param.department.no_faculty)
                }
                noOfRecordsAffected=dbConnection.insert(Students){
                    set(it.dept_id,param.dept_no)
                    set(it.first_name,param.first_name)
                    set(it.last_name,param.last_name)
                    set(it.mail_id,param.mail_id)
                    set(it.roll_no,param.roll_no)
                }
                transaction.commit()

            }else{
                transaction.rollback()
                noOfRecordsAffected=0
            }


        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
            noOfRecordsAffected = 0
        }finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }

    fun shouldRollback(params: StudentDTO): Boolean {
        if (params.dept_no == params.department.dept_no) {
            return true
        }
        else {
            return false
        }
    }
    /*----------------------get student with department----------------------------------*/

    suspend fun getStudentWithDepartment():List<StudentDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Students).joinReferencesAndSelect().map { row ->Students.createEntity(row)  }
                .map{
                    StudentDTO(
                    it.roll_no,
                    it.first_name,
                    it.last_name,
                    it.mail_id,
                    it.dept_no, DepartmentDTO(
                        it.department.dept_no,
                        it.department.dept_name,
                        it.department.dept_head,
                        it.department.no_faculty
                    )
                )
                }
        }
    }
    suspend fun getStudents():List<Student>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Students).select()
                .map { row ->Students.createEntity(row) }
        }
    }

}
