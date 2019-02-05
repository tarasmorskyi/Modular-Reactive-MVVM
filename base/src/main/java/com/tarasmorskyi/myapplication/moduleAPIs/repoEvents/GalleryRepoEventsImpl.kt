package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.gallery.api.GalleryRepoEvents
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.remote.RemoteRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class GalleryRepoEventsImpl @Inject constructor(
    private val local: LocalRepository,
    private val remote: RemoteRepository
) : GalleryRepoEvents {

    override fun like(post: Post): Completable = remote.likePost(post)

    override val posts: Maybe<List<Post>>
        get() = local.searchSettings.flatMap { searchSettings: SearchSettings -> remote.getPages(searchSettings) }

}