package com.tarasmorskyi.gallery.interactors

import com.squareup.picasso.Picasso
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.gallery.api.GalleryRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class GalleryInteractorImpl @Inject constructor(
    private val galleryRepoEvents: GalleryRepoEvents
) : GalleryInteractor {

    override fun like(post: Post): Completable = galleryRepoEvents.like(post)

    override val posts: Maybe<List<Post>>
        get() = galleryRepoEvents.posts.flatMap { it ->
            Observable.fromIterable(it)
                .filter { it.images.isNotEmpty() && it.images[0].type == "image/jpeg" }
                .map {
                    Picasso.get()
                        .load(it.images[0].link)
                        .fetch()
                    return@map it
                }
                .toList().toMaybe()
        }

}