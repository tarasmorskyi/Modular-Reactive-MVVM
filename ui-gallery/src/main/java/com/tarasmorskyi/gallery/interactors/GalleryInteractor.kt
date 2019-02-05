package com.tarasmorskyi.gallery.interactors

import com.tarasmorskyi.dataModel.Post
import io.reactivex.Completable
import io.reactivex.Maybe

interface GalleryInteractor {
    val posts: Maybe<List<Post>>
    fun like(post: Post): Completable
}