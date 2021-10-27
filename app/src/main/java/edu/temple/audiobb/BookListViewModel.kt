package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookListViewModel : ViewModel() {
    private val bookLiveData = MutableLiveData<BookList>()

    fun getBookList () : LiveData<BookList> {
        return bookLiveData
    }

    fun setBookList(book: BookList) {
        bookLiveData.value = book
    }
}