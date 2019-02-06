package com.tarasmorskyi.gallery.interactors

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.gallery.api.GalleryRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class GalleryInteractorImpl @Inject constructor(
    private val galleryRepoEvents: GalleryRepoEvents
) : GalleryInteractor {

    override fun like(post: Post): Completable = galleryRepoEvents.like(post)

    override val posts: Maybe<List<Post>>
        get() = galleryRepoEvents.posts

}