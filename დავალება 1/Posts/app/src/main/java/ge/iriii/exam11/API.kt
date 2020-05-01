package ge.iriii.exam11

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("posts/")
    fun getPosts() : Call<List<PostItem>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") id : Int) : Call<List<CommentItem>>
}