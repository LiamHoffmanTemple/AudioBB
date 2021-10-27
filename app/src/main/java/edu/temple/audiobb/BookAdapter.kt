package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (_books : BookList, _OC : View.OnClickListener) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val books = _books
    val OC = _OC

    class ViewHolder(_view: View ): RecyclerView.ViewHolder(_view) {
        val authorView = _view.findViewById<TextView>(R.id.bookAuthorTextView)
        val titleView = _view.findViewById<TextView>(R.id.bookTitleTextView)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.book_list, parent, false)
        view.setOnClickListener(OC)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = books.get(position).title
        holder.authorView.text = books.get(position).author
    }

    override fun getItemCount(): Int {
        return books.size()
    }
}