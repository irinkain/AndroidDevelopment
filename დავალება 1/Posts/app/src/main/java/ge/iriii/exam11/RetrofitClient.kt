package ge.iriii.exam11

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val client : RetrofitClient = RetrofitClient()
    }

    private var retrofit: Retrofit

    init {
        val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api() : API
    {
        return retrofit.create(API::class.java)
    }
 /*   private fun instance() : RetrofitClient
    {
        if(client == null)
            client = RetrofitClient()
        return client
    } */
}