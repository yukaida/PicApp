package com.yukaida.picapp.netWork

import com.yukaida.picapp.bean.BeautyItemJson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author yukaida
 * @DATE 2021/1/4.
 */
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.apiopen.top/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiServer: ApiServer by lazy {
    retrofit.create(ApiServer::class.java)
}

interface ApiServer {

    @GET("getImages")
    suspend fun getPic(@Query("page") pageInt: Int, @Query("count") countInt: Int):BeautyItemJson

}