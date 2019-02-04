package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.mygallery.api.MyGalleryRepoEvents
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.remote.RemoteRepository
import io.reactivex.Maybe
import javax.inject.Inject

class MyGalleryRepoEventsImpl @Inject constructor(
    private val local: LocalRepository,
    private val remote: RemoteRepository
) : MyGalleryRepoEvents {
    override val posts: Maybe<List<Post>>
        get() = local.userAuthenticationData.flatMap { remote.getMyPages(it.accountUsername) }
}