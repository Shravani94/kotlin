package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Book:Entity<Book> {
    val bookname:String
    val author:String
    val noOfChap:Int
    val yearOfPublishing:Int

}
object Books:Table<Book>("books"){
    val bookname=varchar("bookname").primaryKey().bindTo { it.bookname }
    val author=varchar("author").bindTo { it.author }
    val noOfChap=int("noOfChap").bindTo { it.noOfChap }
    val yearOfPublishing=int("yearOfPublishing").bindTo { it.yearOfPublishing }
}