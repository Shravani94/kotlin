package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface BookShop:Entity<BookShop> {
    val bookNo:Int
    val bookname:String
    val noOfPages:Int
    val bookPrice:Int
    val addid:Int
    val book:Book
    val address:Address
}
object BookShops:Table<BookShop>("bookshop"){
    val bookNo=int("bookNo").primaryKey().bindTo { it.bookNo }
    val noOfPages=int("noOfPages").bindTo { it.noOfPages }
    val bookPrice=int("bookPrice").bindTo { it.bookPrice }
    val addid=int("addid").references(Addresses){it.address}
    val bookname=varchar("bookname").references(Books){it.book}

}