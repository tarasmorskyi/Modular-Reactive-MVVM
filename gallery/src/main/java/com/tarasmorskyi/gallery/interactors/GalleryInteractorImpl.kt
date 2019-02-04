package com.tarasmorskyi.gallery.interactors

import com.tarasmorskyi.gallery.api.GalleryRepoEvents
import com.tarasmorskyi.dataModel.Post
import io.reactivex.Maybe
import javax.inject.Inject

class GalleryInteractorImpl @Inject constructor(val galleryRepoEvents: GalleryRepoEvents) : GalleryInteractor {
    override val posts: Maybe<List<Post>>
        get() = galleryRepoEvents.posts

}