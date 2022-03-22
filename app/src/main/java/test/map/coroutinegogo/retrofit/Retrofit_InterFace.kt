package test.map.coroutinegogo.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import test.map.coroutinegogo.StationBus

interface Retrofit_InterFace {

    @GET("BusSttnInfoInqireService/getSttnNoList")
    fun StationNameGet(
        @Query("cityCode") cityCode:String,
        @Query("nodeNm") staionName:String?,
        @Query("nodeNo") nodeNo:String?
    ) : Call<StationBus>


    @GET("BusSttnInfoInqireService/getSttnNoList")
    suspend fun CoroutineStationNameGet(
        @Query("cityCode") cityCode:String,
        @Query("nodeNm") staionName:String?,
        @Query("nodeNo") nodeNo:String?
    ) : Response<StationBus>

}