package com.rabbit.green.nasaopen

import okhttp3.*

class LocalClientInterceptor(var resourceProvider: IResourceProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return Response.Builder().addHeader("content-type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"),
                        resourceProvider.getJsonResource(R.raw.data)))
                .code(200)
                .message("Mock response")
                .protocol(Protocol.HTTP_1_0)
                .request(chain.request())
                .build()
    }

}