package com.rabbit.green.nasaopen.data.model

import com.squareup.moshi.Json

data class Item(var copyright: String?,
                var date: String?,
                var explanation: String?,
                var hdurl: String?,
                @Json(name = "media_type")
                var mediaType: String?,
                @Json(name = "service_version")
                var serviceVersion: String?,
                var title: String?,
                var url: String?)

