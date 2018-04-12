package com.rabbit.green.nasaopen.data.source.net

import com.rabbit.green.nasaopen.data.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRepositoryRestService {

    @GET("apod")
    fun getItem(@Query("api_key") apiKey: String) : Call<Item>

}