package com.rabbit.green.nasaopen

import android.content.Context
import java.io.InputStream

class MockResourceProvider(var context: Context) : IResourceProvider {

    private val EMPTY_JSON = "{}"

    override fun getJsonResource(id: Int): String {
        var inputStream: InputStream = context.resources.openRawResource(id)
        var content: ByteArray = ByteArray(inputStream.available())
        return if (inputStream.read(content) >= 0) String(content) else EMPTY_JSON
    }
}