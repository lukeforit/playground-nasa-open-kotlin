package com.rabbit.green.nasaopen.data.source.net

import com.rabbit.green.nasaopen.data.model.Item

class Repository(var service: IRepositoryRestService) : IRepository {

    override fun getItem(id: Int): Item {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}