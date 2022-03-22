package test.map.coroutinegogo.retrofit

import retrofit2.Call
import retrofit2.http.GET
import test.map.coroutinegogo.multiRecyclerView.ui.HomeRecyclerViewItem

interface Api {

    @GET("v3/d8a4f47f-a673-4a2f-befc-c42d5b7dcb17")
    fun getMoview() : List<HomeRecyclerViewItem.Movie>

    @GET("v3/1d41a392-b3fa-43f1-bc3b-7aeb81210589")
    fun getDirectors() : Call<HomeRecyclerViewItem.Director>
}