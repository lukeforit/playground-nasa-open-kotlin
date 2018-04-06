package com.rabbit.green.nasaopen.data.model

data class Item(var textProperty: String, var value : Int){
    fun multiplyBy(modifier: Int) : Int {
        return value * modifier
    }
}

