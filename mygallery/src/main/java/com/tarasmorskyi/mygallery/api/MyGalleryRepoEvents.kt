package com.tarasmorskyi.mygallery.api

import com.tarasmorskyi.dataModel.Post
import io.reactivex.Maybe

interface MyGalleryRepoEvents {
    val posts: Maybe<List<Post>>
}