package edu.temple.audiobb

import java.io.Serializable;

class BookList : Serializable {

    var dataList = mutableListOf<Book>()

    fun add(book:Book){
        dataList.add(book)
    }

    fun remove(book:Book){
        dataList.remove(book)
    }

    fun get(index:Int): Book {
        return dataList[index]
    }

    fun size() : Int {
        return dataList.size
    }


}