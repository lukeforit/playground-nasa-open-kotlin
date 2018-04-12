package com.rabbit.green.nasaopen

import android.support.annotation.RawRes

interface IResourceProvider {
    fun getJsonResource(@RawRes id: Int) : String
}