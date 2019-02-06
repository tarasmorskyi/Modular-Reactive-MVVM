package com.tarasmorskyi.gallery.api

import com.tarasmorskyi.dataModel.Post
import io.reactivex.Completable
import io.reactivex.Maybe

interface GalleryRepoEvents {

    val posts: Maybe<List<Post>>

    fun like(post: Post): Completable
}