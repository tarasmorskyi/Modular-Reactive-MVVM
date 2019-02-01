package com.opensport.gallery.interactors

import com.tarasmorskyi.data_model.Post
import io.reactivex.Maybe

interface GalleryInteractor {
    val posts: Maybe<List<Post>>
}