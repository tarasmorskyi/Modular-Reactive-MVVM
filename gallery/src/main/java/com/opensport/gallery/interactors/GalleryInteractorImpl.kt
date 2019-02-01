package com.opensport.gallery.interactors

import com.opensport.gallery.api.GalleryRepoEvents
import com.tarasmorskyi.data_model.Post
import io.reactivex.Maybe
import javax.inject.Inject

class GalleryInteractorImpl @Inject constructor(val galleryRepoEvents: GalleryRepoEvents) : GalleryInteractor {
    override val posts: Maybe<List<Post>>
        get() = galleryRepoEvents.posts

}