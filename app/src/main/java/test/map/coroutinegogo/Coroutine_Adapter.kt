package test.map.coroutinegogo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.coroutinegogo.databinding.RetrofitItemBinding

class Coroutine_Adapter: RecyclerView.Adapter<Coroutine_Adapter.MvvmViewHolder>() {
    lateinit var stationItem: List<StationItem>

    inner class MvvmViewHolder(private val binding: RetrofitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stationItem: StationItem) {

            //data binding으로 코드가 간결해짐
            binding.stationitem = stationItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MvvmViewHolder {
        val view = RetrofitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MvvmViewHolder(view)
    }

    override fun onBindViewHolder(holder: MvvmViewHolder, position: Int) {
        holder.bind(stationItem[position])
    }

    override fun getItemCount(): Int {
        return stationItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<StationItem>) {
        stationItem = list
        notifyDataSetChanged()
    }
}