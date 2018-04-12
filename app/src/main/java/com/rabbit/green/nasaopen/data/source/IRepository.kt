package com.rabbit.green.nasaopen.data.source

import com.rabbit.green.nasaopen.data.model.Item

interface IRepository {
    fun getItem() : Item?
}