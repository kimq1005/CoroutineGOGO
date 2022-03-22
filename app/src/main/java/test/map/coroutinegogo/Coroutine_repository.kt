package test.map.coroutinegogo

import retrofit2.http.Query
import test.map.coroutinegogo.retrofit.Retrofit_Client
import test.map.coroutinegogo.retrofit.Retrofit_InterFace

class Coroutine_repository {

    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient("http://openapi.tago.go.kr/openapi/service/")
            .create(Retrofit_InterFace::class.java)

    suspend fun coroutineBusNameGet(cityCode:String, staionName:String?, nodeNo:String)=
        retrofitInterface.CoroutineStationNameGet(cityCode, staionName, nodeNo)
}