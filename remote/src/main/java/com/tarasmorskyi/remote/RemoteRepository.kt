package com.tarasmorskyi.remote

import com.serjltt.moshi.adapters.Wrapped
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.dataModel.SearchSettings
import io.reactivex.Completable
import io.reactivex.Maybe
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface RemoteRepository {

    fun getPages(searchSettings: SearchSettings): Maybe<List<Post>>

    fun getMyPages(username: String): Maybe<List<Post>>

    fun likePost(page: Post): Completable

    interface RemoteService {

        @Wrapped(path = arrayOf("data"))
        @GET("3/gallery/{section}/{sort}/{window}/{page}")
        fun getPages(
            @Path("section") section: String,
            @Path("sort") sort: String, @Path("window") window: String,
            @Path("page") page: Int, @Query("showViral") showViral: Boolean,
            @Query("mature") mature: Boolean
        )
                : Maybe<Result<List<Post>>>

        @Wrapped(path = arrayOf("data"))
        @GET("3/account/{username}/favorites/0/newest")
        fun getMyPages(@Path("username") username: String)
                : Maybe<Result<List<Post>>>

        @POST("3/image/{imageHash}/favorite")
        fun votePost(@Path("imageHash") imageHash: String)
                : Maybe<Result<String>>
    }

}
