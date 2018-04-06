package com.rabbit.green.nasaopen.data.source.net

import com.rabbit.green.nasaopen.data.model.Item

interface IRepository {
    fun getItem(id : Int) : Item
}