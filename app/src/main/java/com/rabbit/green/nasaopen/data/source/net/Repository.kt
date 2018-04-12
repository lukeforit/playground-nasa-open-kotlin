package com.rabbit.green.nasaopen.data.source.net

import com.rabbit.green.nasaopen.BuildConfig
import com.rabbit.green.nasaopen.data.model.Item
import com.rabbit.green.nasaopen.data.source.IRepository

class Repository(var service: IRepositoryRestService) : IRepository {

    override fun getItem(): Item? {
        return service.getItem(BuildConfig.apiKey).execute().body()
    }
}