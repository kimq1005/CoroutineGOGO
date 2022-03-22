package test.map.coroutinegogo.multiRecyclerView.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import test.map.coroutinegogo.databinding.DirectorItemBinding
import test.map.coroutinegogo.databinding.MovieItemBinding
import test.map.coroutinegogo.databinding.TitleItemBinding

sealed class HomeRecylcerViewHolder(binding : ViewBinding):RecyclerView.ViewHolder(binding.root) {

    class  TitleViewHolder(private val binding: TitleItemBinding) : HomeRecylcerViewHolder(binding){
        fun bind(title : HomeRecyclerViewItem.Title){
            binding.textViewTitle.text = title.title

        }
    }


    class MovieViewHolder(private val binding : MovieItemBinding ) : HomeRecylcerViewHolder(binding){
        fun bind(title : HomeRecyclerViewItem.Movie){

            Glide.with(itemView).load(title.thumbnail).into(binding.imageViewMoview)

        }
    }

    class DirectorViewHolder(private val binding : DirectorItemBinding ) : HomeRecylcerViewHolder(binding){
        fun bind(director : HomeRecyclerViewItem.Director){

            Glide.with(itemView).load(director.avatar).into(binding.imageViewDirector)
            binding.textViewName.text = director.name
            binding.textViewMovies.text = director.movie_count

        }
    }

}