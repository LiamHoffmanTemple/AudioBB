package edu.temple.audiobb

class BookList {

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