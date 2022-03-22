package test.map.coroutinegogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response
import test.map.coroutinegogo.databinding.ActivityMainBinding
import test.map.coroutinegogo.multiRecyclerView.Multi_RecyclerView_MainActivity
import test.map.coroutinegogo.retrofit.Retrofit_Client
import test.map.coroutinegogo.retrofit.Retrofit_InterFace
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    var TAG: String = "로그"
    private lateinit var job: Job


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient("http://openapi.tago.go.kr/openapi/service/")
            .create(Retrofit_InterFace::class.java)

    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    lateinit var coroutineAdapter: Coroutine_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CallBtn.setOnClickListener {
            retrofitCall()
        }

        binding.IntentBtn.setOnClickListener {
            val intent = Intent(this,Multi_RecyclerView_MainActivity::class.java)
            startActivity(intent)
        }




    }

    private fun retrofitCall() {
        coroutineAdapter = Coroutine_Adapter()

        CoroutineScope(Dispatchers.Main).launch {
            val call = retrofitInterface.CoroutineStationNameGet("31010", "우남", null)
            if (call.isSuccessful) {
                val body = call.body()!!.body.items.item
                binding.coroutineRecyclerView.apply {
                    adapter = coroutineAdapter
                    layoutManager = LinearLayoutManager(context)
                    coroutineAdapter.submitList(body)

                }

            }
        }
    }

    private fun coroutine_RetrofitCall() {
        launch(coroutineContext) {
            try {
                withContext(Dispatchers.IO) {
                    val call = retrofitInterface.CoroutineStationNameGet("31010", "우남", null)

                    if (call.isSuccessful) {
                        val body = call.body()!!.body.items.item

                        binding.coroutineRecyclerView.apply {
                            adapter = coroutineAdapter
                            layoutManager = LinearLayoutManager(context)
                            coroutineAdapter.submitList(body)

                        }

                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, "coroutine_RetrofitCall: ${e.printStackTrace()}")
            }
        }

    }

}