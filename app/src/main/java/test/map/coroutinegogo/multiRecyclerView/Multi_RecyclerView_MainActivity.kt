package test.map.coroutinegogo.multiRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import retrofit2.create
import test.map.coroutinegogo.databinding.ActivityMultiRecyclerViewMainBinding
import test.map.coroutinegogo.multiRecyclerView.ui.HomeRecyclerViewAdapter
import test.map.coroutinegogo.multiRecyclerView.ui.HomeRecyclerViewItem
import test.map.coroutinegogo.retrofit.Api
import test.map.coroutinegogo.retrofit.Retrofit_Client
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class Multi_RecyclerView_MainActivity : AppCompatActivity() {
    private var multiRecyclerViewMainBinding : ActivityMultiRecyclerViewMainBinding?=null
    private val binding get() = multiRecyclerViewMainBinding!!

    private lateinit var job: Job


    private val retrofitInterface : Api =
        Retrofit_Client.getClient("https://run.mocky.io/").create(
            Api::class.java
        )

    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        multiRecyclerViewMainBinding = ActivityMultiRecyclerViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = retrofitInterface.getDirectors()


        job = Job()

        binding.recyclerview.apply {

            val hello = listOf(
                HomeRecyclerViewItem.Movie(
                    id = 1,
                    "ss",
                    "aa",
                    "awda"
                )
            )

            homeRecyclerViewAdapter = HomeRecyclerViewAdapter()
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Multi_RecyclerView_MainActivity)
            adapter = homeRecyclerViewAdapter
            homeRecyclerViewAdapter.submitList(hello)
        }

        //Luda
        //https://run.mocky.io/v3/d8a4f47f-a673-4a2f-befc-c42d5b7dcb17


        //IU
        //https://run.mocky.io/v3/1d41a392-b3fa-43f1-bc3b-7aeb81210589
    }

    private fun retrofitCall(){


    }


}