package com.tarasmorskyi.remote

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.dataModel.SearchSettings
import dagger.Reusable
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject


@Reusable
class RemoteRepositoryImpl @Inject internal constructor(
    retrofit: Retrofit
) : RemoteRepository {

    private val service: RemoteRepository.RemoteService = retrofit.create(RemoteRepository.RemoteService::class.java)

    override fun getPages(searchSettings: SearchSettings): Maybe<List<Post>> {
        return service.getPages(
            searchSettings.section,
            searchSettings.sort, searchSettings.window, 0, searchSettings.showViral,
            searchSettings.mature
        )
            .subscribeOn(Schedulers.io())
            .compose(RxUtils.transformMaybeResult())
    }

    override fun getMyPages(username: String): Maybe<List<Post>> {
        return service.getMyPages(username)
            .subscribeOn(Schedulers.io())
            .compose(RxUtils.transformMaybeResult())
    }

    override fun likePost(post: Post): Completable {
        val link = if (post.images.isNotEmpty()) post.images[0].id else post.id
        return service.votePost(link)
            .subscribeOn(Schedulers.io())
            .toSingle().ignoreElement()
    }
}