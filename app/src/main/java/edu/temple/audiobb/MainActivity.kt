package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var twoPane = false
    lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var books:BookList = BookList()
        books.add(Book("A Game of Thrones","George R. R. Martin"))
        books.add(Book("The Lightning Thief","Rick Riordan"))
        books.add(Book("The Ruins of Gorlan","John Flanagan"))
        books.add(Book("Fahrenheit 451","Ray Bradbury"))
        books.add(Book("1984","George Orwell"))
        books.add(Book("The Hobbit","J.R.R. Tolkien"))
        books.add(Book("Watchmen","Alan Moore"))
        books.add(Book("The Iliad","Homer"))
        books.add(Book("Moby-Dick","Herman Melville"))
        books.add(Book("The Alchemist","Paulo Coelho"))



        supportFragmentManager.beginTransaction()
            .replace(R.id.bookListFragment, BookListFragment.newInstance(books))
            .addToBackStack(null)
            .commit()
    }
}