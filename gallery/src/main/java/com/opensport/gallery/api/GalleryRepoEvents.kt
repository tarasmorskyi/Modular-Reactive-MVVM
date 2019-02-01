package com.opensport.gallery.api

import com.tarasmorskyi.data_model.Post
import io.reactivex.Maybe

interface GalleryRepoEvents {
    val posts: Maybe<List<Post>>
}