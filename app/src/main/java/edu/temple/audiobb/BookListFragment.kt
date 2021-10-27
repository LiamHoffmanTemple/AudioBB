package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val BOOKS_KEY = "books"


class BookListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var books: BookList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            books = it.getSerializable(BOOKS_KEY) as BookList
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)

        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val bookListViewModel = ViewModelProvider(requireActivity()).get(BookListViewModel::class.java)
        val bookViewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
        val bookList = bookListViewModel.getBookList().value
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            bookViewModel.setBook(books.dataList[itemPosition])
        }

        recyclerView.adapter = BookAdapter(books, onClickListener)

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(books:BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                   putSerializable(BOOKS_KEY, books)
                }
            }
    }
}