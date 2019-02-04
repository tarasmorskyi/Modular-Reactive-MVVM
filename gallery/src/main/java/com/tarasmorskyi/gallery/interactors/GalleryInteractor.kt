package com.tarasmorskyi.gallery.interactors

import com.tarasmorskyi.dataModel.Post
import io.reactivex.Maybe

interface GalleryInteractor {
    val posts: Maybe<List<Post>>
}