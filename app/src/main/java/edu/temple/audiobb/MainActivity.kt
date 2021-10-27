package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), BookListFragment.DoubleLayout {

    private val blankBook = Book("", "")
    var doubleFragment = false
    lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("AudioBB")

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

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        doubleFragment = findViewById<FragmentContainerView>(R.id.bookDetailsContainer) != null

        //First load
        if (savedInstanceState == null) {
            bookViewModel.setSelectedBook(blankBook)

            if (doubleFragment) {
                //Don't add to back stack
                supportFragmentManager.beginTransaction()
                    .add(R.id.bookListContainer, BookListFragment.newInstance(books))
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.bookListContainer, BookListFragment.newInstance(books))
                    .addToBackStack(null)
                    .commit()
            }
        }

        //Double screen
        if (doubleFragment) {

            if (supportFragmentManager.findFragmentById(R.id.bookListContainer) is BookDetailsFragment) {
                supportFragmentManager.popBackStack()
            }

            //If was single, and is now double
            if (supportFragmentManager.findFragmentById(R.id.bookDetailsContainer) == null) {

                //Put RecyclerView back in fragmentContainerView1
                supportFragmentManager.beginTransaction()
                    .add(R.id.bookDetailsContainer, BookDetailsFragment.newInstance())
                    .commit()
            }
        } else if (bookViewModel.getSelectedBook().value != blankBook) {

            supportFragmentManager.beginTransaction()
                .replace(R.id.bookListContainer, BookDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun selectionMade() {
        if (!doubleFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.bookListContainer, BookDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}