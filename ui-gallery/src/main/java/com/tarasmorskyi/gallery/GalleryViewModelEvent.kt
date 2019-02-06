package com.tarasmorskyi.gallery

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.uicore.BaseViewModelEvent

sealed class GalleryViewModelEvent : BaseViewModelEvent {

    object GetPosts : GalleryViewModelEvent()

    data class PostClicked(val post: Post) : GalleryViewModelEvent()

    data class Like(val post: Post) : GalleryViewModelEvent()
}