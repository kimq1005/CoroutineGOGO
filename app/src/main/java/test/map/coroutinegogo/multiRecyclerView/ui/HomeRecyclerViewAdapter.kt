package test.map.coroutinegogo.multiRecyclerView.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.coroutinegogo.R
import test.map.coroutinegogo.databinding.DirectorItemBinding
import test.map.coroutinegogo.databinding.MovieItemBinding
import test.map.coroutinegogo.databinding.TitleItemBinding
import java.lang.IllegalArgumentException

//테스트1
class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecylcerViewHolder>() {

    var items = listOf<HomeRecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecylcerViewHolder {
       return when (viewType) {
            R.layout.title_item -> {
                HomeRecylcerViewHolder.TitleViewHolder(
                    TitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                )
            }

            R.layout.movie_item -> {
                HomeRecylcerViewHolder.MovieViewHolder(
                    MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }

            R.layout.director_item -> {
                HomeRecylcerViewHolder.DirectorViewHolder(
                    DirectorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )

            }

            else -> throw IllegalArgumentException("Error")
        }
    }

    override fun onBindViewHolder(holder: HomeRecylcerViewHolder, position: Int) {
        when(holder){
            is HomeRecylcerViewHolder.DirectorViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Director)
            is HomeRecylcerViewHolder.MovieViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Movie)
            is HomeRecylcerViewHolder.TitleViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Title)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeRecyclerViewItem.Director -> R.layout.director_item
            is HomeRecyclerViewItem.Movie -> R.layout.movie_item
            is HomeRecyclerViewItem.Title -> R.layout.title_item
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list:List<HomeRecyclerViewItem>){
        items = list
        notifyDataSetChanged()
    }
}