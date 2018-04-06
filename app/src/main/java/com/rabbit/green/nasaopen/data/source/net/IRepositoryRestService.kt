package com.rabbit.green.nasaopen.data.source.net

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRepositoryRestService {

    @GET("/path/to/{id}")
    fun getItem(@Path("id") id: Int, @Query("api_key") apiKey: String)

}