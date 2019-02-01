package com.opensport.mygallery.api

import com.tarasmorskyi.data_model.Post
import io.reactivex.Maybe

interface MyGalleryRepoEvents {
    val posts: Maybe<List<Post>>
}